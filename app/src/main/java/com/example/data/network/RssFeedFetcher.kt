package com.example.data.network

import android.util.Xml
import com.example.data.local.entity.ArticleEntity
import com.example.data.model.Newspaper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.StringReader
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

class RssFeedFetcher {
    private val client = OkHttpClient.Builder()
        .connectTimeout(4, TimeUnit.SECONDS)
        .readTimeout(4, TimeUnit.SECONDS)
        .followRedirects(true)
        .build()

    private val userAgent = "Mozilla/5.0 (Linux; Android 14; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Mobile Safari/537.36"

    suspend fun fetchAllRealtime(newspapers: List<Newspaper>): List<ArticleEntity> = coroutineScope {
        val candidates = newspapers.filter { it.rssUrl != null }
        val deferredArticles = candidates.map { newspaper ->
            async(Dispatchers.IO) {
                fetchFromNewspaper(newspaper)
            }
        }
        deferredArticles.awaitAll().flatten()
    }

    suspend fun fetchFromNewspaper(newspaper: Newspaper): List<ArticleEntity> = withContext(Dispatchers.IO) {
        val rssUrl = newspaper.rssUrl ?: return@withContext emptyList()
        try {
            val request = Request.Builder()
                .url(rssUrl)
                .header("User-Agent", userAgent)
                .header("Accept", "application/rss+xml, application/xml, text/xml, application/atom+xml, */*")
                .header("Accept-Language", "bn-BD,bn;q=0.9,en-US;q=0.8,en;q=0.7")
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) return@withContext emptyList()
                val xmlBody = response.body?.string() ?: return@withContext emptyList()
                parseRssXml(xmlBody, newspaper)
            }
        } catch (_: Exception) {
            emptyList()
        }
    }

    private fun parseRssXml(xml: String, newspaper: Newspaper): List<ArticleEntity> {
        val articles = mutableListOf<ArticleEntity>()
        try {
            val parser: XmlPullParser = try {
                XmlPullParserFactory.newInstance().newPullParser()
            } catch (_: Exception) {
                Xml.newPullParser()
            }
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(StringReader(xml))

            var eventType = parser.eventType
            var insideItem = false

            var title = ""
            var link = ""
            var description = ""
            var pubDateStr = ""
            var imageUrl = ""

            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name?.lowercase(Locale.ROOT) ?: ""

                when (eventType) {
                    XmlPullParser.START_TAG -> {
                        if (tagName == "item" || tagName == "entry") {
                            insideItem = true
                            title = ""
                            link = ""
                            description = ""
                            pubDateStr = ""
                            imageUrl = ""
                        } else if (insideItem) {
                            when (tagName) {
                                "title" -> title = safeNextText(parser)
                                "link" -> {
                                    val href = parser.getAttributeValue(null, "href")
                                    link = if (!href.isNullOrBlank()) href else safeNextText(parser)
                                }
                                "description", "summary", "content:encoded" -> {
                                    val desc = safeNextText(parser)
                                    if (description.isBlank() || desc.length > description.length) {
                                        description = desc
                                    }
                                }
                                "pubdate", "published", "updated" -> pubDateStr = safeNextText(parser)
                                "enclosure" -> {
                                    val type = parser.getAttributeValue(null, "type") ?: ""
                                    if (type.startsWith("image") || imageUrl.isBlank()) {
                                        imageUrl = parser.getAttributeValue(null, "url") ?: ""
                                    }
                                }
                                "media:content", "media:thumbnail" -> {
                                    val url = parser.getAttributeValue(null, "url")
                                    if (!url.isNullOrBlank() && imageUrl.isBlank()) {
                                        imageUrl = url
                                    }
                                }
                            }
                        }
                    }
                    XmlPullParser.END_TAG -> {
                        if (tagName == "item" || tagName == "entry") {
                            insideItem = false
                            if (title.isNotBlank() && (link.isNotBlank() || title.length > 5)) {
                                val cleanTitle = cleanHtml(title)
                                val cleanDesc = cleanHtml(description)
                                val resolvedImage = if (imageUrl.isNotBlank()) imageUrl else extractImageFromHtml(description)
                                val fallbackImage = if (resolvedImage.isNotBlank()) resolvedImage
                                else "https://images.unsplash.com/photo-1585829365295-ab7cd400c167?w=800&auto=format&fit=crop"

                                val parsedTime = parseDateMillis(pubDateStr)
                                val articleId = "${newspaper.id}_${(link.ifBlank { cleanTitle }).hashCode()}"

                                val hasBreakingKeyword = cleanTitle.contains("ব্রেকিং") || 
                                    cleanTitle.contains("জরুরি") || 
                                    cleanTitle.contains("নিহত") || 
                                    cleanTitle.contains("ঘূর্ণিঝড়") || 
                                    cleanTitle.contains("ভূমিকম্প") || 
                                    cleanTitle.contains("বন্যা") || 
                                    cleanTitle.contains("Breaking", ignoreCase = true) || 
                                    cleanTitle.contains("Urgent", ignoreCase = true)
                                val isBreakingStory = hasBreakingKeyword || (articles.isEmpty() && newspaper.id in listOf("prothom_alo", "bbc_bangla", "bdnews24", "the_daily_star"))
                                val isTopStory = (articles.size <= 2 && newspaper.id in listOf("prothom_alo", "the_daily_star", "bbc_bangla", "jago_news_24", "risingbd", "ittefaq", "kaler_kantho", "somokal", "jugantor")) || (articles.size < 2)

                                val excerpt = if (cleanDesc.length > 280) cleanDesc.take(277) + "..." else cleanDesc

                                articles.add(
                                    ArticleEntity(
                                        id = articleId,
                                        newspaperId = newspaper.id,
                                        newspaperName = newspaper.name,
                                        newspaperBanglaName = newspaper.banglaName,
                                        title = cleanTitle,
                                        description = excerpt,
                                        content = if (excerpt.isNotBlank()) excerpt else cleanTitle,
                                        articleUrl = link.ifBlank { newspaper.websiteUrl },
                                        imageUrl = fallbackImage,
                                        category = newspaper.category.displayName,
                                        publishedAt = parsedTime,
                                        formattedTime = formatRelativeTime(parsedTime),
                                        isTopNews = isTopStory,
                                        isBreaking = isBreakingStory,
                                        isSaved = false
                                    )
                                )
                            }
                        }
                    }
                }
                eventType = parser.next()
            }
        } catch (e: Exception) {
            // gracefully fallback
        }
        return articles
    }

    private fun safeNextText(parser: XmlPullParser): String {
        return try {
            parser.nextText().trim()
        } catch (e: Exception) {
            ""
        }
    }

    private fun cleanHtml(html: String): String {
        return html.replace(Regex("<.*?>"), " ")
            .replace("&nbsp;", " ")
            .replace("&amp;", "&")
            .replace("&quot;", "\"")
            .replace("&#39;", "'")
            .replace("&lt;", "<")
            .replace("&gt;", ">")
            .replace(Regex("\\s+"), " ")
            .trim()
    }

    private fun extractImageFromHtml(html: String): String {
        val matcher = Pattern.compile("<img[^>]+src=[\"']([^\"']+)[\"']").matcher(html)
        return if (matcher.find()) matcher.group(1) ?: "" else ""
    }

    private fun parseDateMillis(dateStr: String): Long {
        if (dateStr.isBlank()) return System.currentTimeMillis()
        val formats = listOf(
            "EEE, dd MMM yyyy HH:mm:ss Z",
            "EEE, dd MMM yyyy HH:mm:ss z",
            "yyyy-MM-dd'T'HH:mm:ssXXX",
            "yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
            "yyyy-MM-dd'T'HH:mm:ss'Z'"
        )
        for (pattern in formats) {
            try {
                val sdf = SimpleDateFormat(pattern, Locale.ENGLISH)
                val date = sdf.parse(dateStr)
                if (date != null) return date.time
            } catch (_: Exception) {}
        }
        return System.currentTimeMillis()
    }

    private fun formatRelativeTime(timestamp: Long): String {
        val diff = System.currentTimeMillis() - timestamp
        val minutes = diff / (1000 * 60)
        val hours = minutes / 60
        val days = hours / 24

        return when {
            minutes < 1 -> "Just now"
            minutes < 60 -> "$minutes min ago"
            hours < 24 -> "$hours hour${if (hours > 1) "s" else ""} ago"
            days < 7 -> "$days day${if (days > 1) "s" else ""} ago"
            else -> "Recent"
        }
    }
}
