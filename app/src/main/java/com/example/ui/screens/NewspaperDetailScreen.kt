package com.example.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.net.http.SslError
import android.os.Message
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.SslErrorHandler
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.NewspaperDataSource
import com.example.ui.NewsViewModel
import com.example.ui.components.ArticleCard
import com.example.ui.theme.BreakingRed

@SuppressLint("SetJavaScriptEnabled")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewspaperDetailScreen(
    newspaperId: String,
    viewModel: NewsViewModel,
    onBack: () -> Unit,
    onOpenArticle: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val strings by viewModel.appStrings.collectAsStateWithLifecycle()
    val isBn = strings == com.example.util.AppStrings.Bangla
    val favoriteIds by viewModel.favoriteNewspaperIds.collectAsStateWithLifecycle()
    val articles by viewModel.activeNewspaperArticles.collectAsStateWithLifecycle()

    val newspaper = NewspaperDataSource.getById(newspaperId) ?: return
    val webUrlOverride by viewModel.activeWebUrlOverride.collectAsStateWithLifecycle()
    val targetNewsUrl = webUrlOverride ?: newspaper.websiteUrl
    val isFavorite = favoriteIds.contains(newspaper.id)

    // 0 = Live Website (In-App Browser), 1 = Newspaper Articles
    var selectedTab by remember(newspaperId, targetNewsUrl) { mutableIntStateOf(0) }
    var webViewInstance by remember(newspaperId, targetNewsUrl) { mutableStateOf<WebView?>(null) }
    var progress by remember(newspaperId, targetNewsUrl) { mutableFloatStateOf(0f) }
    var isLoading by remember(newspaperId, targetNewsUrl) { mutableStateOf(true) }
    var hasError by remember(newspaperId, targetNewsUrl) { mutableStateOf(false) }

    fun openInExternalBrowser(url: String) {
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(browserIntent)
        } catch (_: Exception) {
            Toast.makeText(
                context,
                if (isBn) "ব্রাউজার খোলা যায়নি" else "Could not open device browser",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // Clean up WebView resources when navigating away to ensure high efficiency and zero memory leaks
    DisposableEffect(newspaperId, targetNewsUrl) {
        onDispose {
            try {
                webViewInstance?.stopLoading()
                webViewInstance?.onPause()
                webViewInstance?.destroy()
                webViewInstance = null
            } catch (_: Exception) {}
        }
    }

    // Intercept hardware/system back button: if webView can go back, navigate back inside the website
    BackHandler(enabled = true) {
        if (selectedTab == 0 && webViewInstance?.canGoBack() == true) {
            webViewInstance?.goBack()
        } else {
            onBack()
        }
    }

    Column(modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        // In-App Browser Top Bar
        CenterAlignedTopAppBar(
            title = {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = newspaper.banglaName.ifBlank { newspaper.name },
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Lock,
                            contentDescription = "Secure",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(11.dp)
                        )
                        Spacer(modifier = Modifier.width(3.dp))
                        Text(
                            text = targetNewsUrl
                                .removePrefix("https://")
                                .removePrefix("http://")
                                .removePrefix("www.")
                                .trimEnd('/'),
                            style = MaterialTheme.typography.labelSmall,
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            },
            navigationIcon = {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.testTag("np_close_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
            },
            actions = {
                // Refresh web page
                IconButton(
                    onClick = {
                        hasError = false
                        isLoading = true
                        webViewInstance?.reload()
                    },
                    modifier = Modifier.testTag("np_reload_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "Reload",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                // Open in External Device Browser
                IconButton(
                    onClick = { openInExternalBrowser(webViewInstance?.url ?: targetNewsUrl) },
                    modifier = Modifier.testTag("np_open_browser_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.OpenInBrowser,
                        contentDescription = "Open in Browser",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }

                // Favorite toggle
                IconButton(
                    onClick = { viewModel.toggleFavoriteNewspaper(newspaper.id, isFavorite) },
                    modifier = Modifier.testTag("np_fav_toggle_btn")
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                        contentDescription = if (isFavorite) "Favorited" else "Favorite",
                        tint = if (isFavorite) BreakingRed else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Share link
                IconButton(
                    onClick = {
                        val currentUrl = webViewInstance?.url ?: targetNewsUrl
                        val sendIntent = Intent(Intent.ACTION_SEND).apply {
                            type = "text/plain"
                            putExtra(Intent.EXTRA_SUBJECT, newspaper.name)
                            putExtra(Intent.EXTRA_TEXT, "${newspaper.banglaName} - ${newspaper.name}\n$currentUrl")
                        }
                        try {
                            context.startActivity(Intent.createChooser(sendIntent, if (isBn) "শেয়ার করুন" else "Share Newspaper"))
                        } catch (_: Exception) {}
                    },
                    modifier = Modifier.testTag("np_share_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Close to return to app grid
                IconButton(
                    onClick = onBack,
                    modifier = Modifier.testTag("np_close_btn")
                ) {
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "Close",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Web Loading Progress Bar
        AnimatedVisibility(
            visible = isLoading && selectedTab == 0,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            LinearProgressIndicator(
                progress = { progress.coerceIn(0.05f, 1f) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
        }

        // View Tabs (In-App Live Website | Curated News Feed)
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = {
                    Text(
                        text = if (isBn) "🌐 লাইভ পোর্টাল / পত্রিকা" else "🌐 Live Website",
                        fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 13.sp
                    )
                },
                modifier = Modifier.testTag("tab_live_website")
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = {
                    Text(
                        text = if (isBn) "📰 সংবাদ তালিকা (${articles.size})" else "📰 News Articles (${articles.size})",
                        fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal,
                        fontSize = 13.sp
                    )
                },
                modifier = Modifier.testTag("tab_newspaper_articles")
            )
        }

        if (selectedTab == 0) {
            // ==================== IN-APP BROWSER (WEBVIEW) ====================
            Box(modifier = Modifier.fillMaxSize()) {
                AndroidView(
                    factory = { ctx ->
                        WebView(ctx).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT
                            )
                            settings.apply {
                                javaScriptEnabled = true
                                domStorageEnabled = true
                                databaseEnabled = true
                                loadWithOverviewMode = true
                                useWideViewPort = true
                                setSupportZoom(true)
                                builtInZoomControls = true
                                displayZoomControls = false
                                cacheMode = WebSettings.LOAD_DEFAULT
                                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                                allowFileAccess = true
                                allowContentAccess = true
                                javaScriptCanOpenWindowsAutomatically = true
                                setSupportMultipleWindows(true)
                                mediaPlaybackRequiresUserGesture = false
                                defaultTextEncodingName = "UTF-8"

                                // Standard Mobile Chrome User-Agent without non-standard app suffixes
                                val defaultUa = userAgentString
                                userAgentString = if (defaultUa.isNullOrBlank()) {
                                    "Mozilla/5.0 (Linux; Android 14; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 Mobile Safari/537.36"
                                } else {
                                    defaultUa.replace("; wv", "").replace("Version/4.0 ", "")
                                }
                            }
                            val webView = this
                            val cookieManager = CookieManager.getInstance()
                            cookieManager.setAcceptCookie(true)
                            cookieManager.setAcceptThirdPartyCookies(webView, true)

                            fun handleUrlNavigation(url: String?): Boolean {
                                if (url.isNullOrBlank()) return false
                                if (url.startsWith("http://") || url.startsWith("https://")) {
                                    return false // keep in this in-app webview
                                }
                                return try {
                                    val intent = if (url.startsWith("intent://")) {
                                        Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
                                    } else {
                                        Intent(Intent.ACTION_VIEW, Uri.parse(url))
                                    }
                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                    ctx.startActivity(intent)
                                    true
                                } catch (_: Exception) {
                                    true // consume unknown schemes to avoid net::ERR_UNKNOWN_URL_SCHEME
                                }
                            }

                            fun handleLoadError(failingUrl: String?) {
                                isLoading = false
                                hasError = true
                                // Do not automatically launch external browser; keep user inside the app
                            }

                            webViewClient = object : WebViewClient() {
                                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                                    return handleUrlNavigation(request?.url?.toString())
                                }

                                @Deprecated("Deprecated in Java")
                                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                                    return handleUrlNavigation(url)
                                }

                                override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                                    // Crucial for Bangladesh Govt (.gov.bd) and local media with intermediate SSL chain issues
                                    handler?.proceed()
                                }

                                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                                    isLoading = true
                                    hasError = false
                                }

                                override fun onPageFinished(view: WebView?, url: String?) {
                                    isLoading = false
                                    try {
                                        CookieManager.getInstance().flush()
                                    } catch (_: Exception) {}
                                }

                                override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                                    if (request?.isForMainFrame == true) {
                                        handleLoadError(request.url?.toString())
                                    }
                                }

                                @Deprecated("Deprecated in Java")
                                override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                                    if (failingUrl == null || failingUrl == targetNewsUrl || failingUrl == view?.url) {
                                        handleLoadError(failingUrl)
                                    }
                                }

                                override fun onReceivedHttpError(view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) {
                                    if (request?.isForMainFrame == true) {
                                        val statusCode = errorResponse?.statusCode ?: 200
                                        if (statusCode >= 400 && statusCode != 401) {
                                            handleLoadError(request.url?.toString())
                                        }
                                    }
                                }
                            }

                            webChromeClient = object : WebChromeClient() {
                                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                                    progress = newProgress / 100f
                                    if (newProgress >= 100) {
                                        isLoading = false
                                    }
                                }

                                override fun onCreateWindow(
                                    view: WebView?,
                                    isDialog: Boolean,
                                    isUserGesture: Boolean,
                                    resultMsg: Message?
                                ): Boolean {
                                    val transport = resultMsg?.obj as? WebView.WebViewTransport ?: return false
                                    val tempWebView = WebView(view?.context ?: return false).apply {
                                        webViewClient = object : WebViewClient() {
                                            override fun shouldOverrideUrlLoading(v: WebView?, request: WebResourceRequest?): Boolean {
                                                val newUrl = request?.url?.toString()
                                                if (!newUrl.isNullOrBlank()) {
                                                    view?.loadUrl(newUrl)
                                                }
                                                return true
                                            }

                                            @Deprecated("Deprecated in Java")
                                            override fun shouldOverrideUrlLoading(v: WebView?, newUrl: String?): Boolean {
                                                if (!newUrl.isNullOrBlank()) {
                                                    view?.loadUrl(newUrl)
                                                }
                                                return true
                                            }
                                        }
                                    }
                                    transport.webView = tempWebView
                                    resultMsg.sendToTarget()
                                    return true
                                }
                            }

                            loadUrl(targetNewsUrl)
                            webViewInstance = this
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .testTag("in_app_webview"),
                    update = { view ->
                        if (view.url != targetNewsUrl && targetNewsUrl.isNotBlank() && view.url == null) {
                            view.loadUrl(targetNewsUrl)
                        }
                    }
                )

                // Error Overlay (Shown only on severe disconnect, keeping WebView alive so reload works)
                if (hasError) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background.copy(alpha = 0.98f)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.4f),
                                modifier = Modifier.size(64.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Icon(
                                        imageVector = Icons.Filled.WifiOff,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.error,
                                        modifier = Modifier.size(32.dp)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            Text(
                                text = if (isBn) "ওয়েবসাইট লোড করতে সমস্যা হয়েছে" else "Could Not Load Website",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurface
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = if (isBn) "ইন্টারনেট সংযোগ বা সার্ভারের সাময়িক সমস্যার কারণে পেজটি লোড হতে পারেনি। অনুগ্রহ করে পুনরায় চেষ্টা করুন।" else "The webpage could not be loaded due to network or server issues. Please tap retry to reload.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(20.dp))

                            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Button(
                                    onClick = {
                                        hasError = false
                                        isLoading = true
                                        webViewInstance?.loadUrl(targetNewsUrl)
                                    },
                                    modifier = Modifier.testTag("retry_webview_btn")
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Refresh,
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(if (isBn) "পুনরায় চেষ্টা করুন" else "Retry")
                                }

                                Button(
                                    onClick = {
                                        val targetUrl = webViewInstance?.url ?: targetNewsUrl
                                        openInExternalBrowser(targetUrl)
                                    },
                                    colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.primary
                                    ),
                                    modifier = Modifier.testTag("open_external_browser_btn")
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.OpenInBrowser,
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text(if (isBn) "ব্রাউজারে খুলুন" else "Open in Browser")
                                }
                            }

                            if (articles.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(12.dp))
                                OutlinedButton(onClick = { selectedTab = 1 }) {
                                    Text(if (isBn) "সংবাদ তালিকা দেখুন (${articles.size})" else "View News Articles (${articles.size})")
                                }
                            }
                        }
                    }
                }

                // In-app web bottom toolbar
                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.95f),
                    tonalElevation = 6.dp,
                    shadowElevation = 8.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 6.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { webViewInstance?.goBack() },
                            enabled = webViewInstance?.canGoBack() == true
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Page Back"
                            )
                        }

                        IconButton(
                            onClick = { webViewInstance?.loadUrl(targetNewsUrl) }
                        ) {
                            Text(
                                text = if (isBn) "হোম" else "Home",
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }

                        // Cross Sign (Close Navigation)
                        IconButton(
                            onClick = onBack,
                            modifier = Modifier.testTag("np_bottom_close_cross_btn")
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Close",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                }
            }
        } else {
            // ==================== CURATED NEWS ARTICLES TAB ====================
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = RoundedCornerShape(10.dp),
                                color = Color(newspaper.primaryColorHex).copy(alpha = 0.15f),
                                modifier = Modifier.size(52.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = newspaper.banglaName.take(3).ifBlank { newspaper.name.take(3) },
                                        color = Color(newspaper.primaryColorHex),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.width(14.dp))

                            Column {
                                Text(
                                    text = newspaper.banglaName,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = newspaper.name,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    text = newspaper.tagline,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }

                if (articles.isEmpty()) {
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f))
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "লাইভ ওয়েবসাইটে পড়ুন",
                                    fontWeight = FontWeight.Bold,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "এই পত্রিকার সমস্ত খবর সরাসরি অ্যাপের মধ্যে লাইভ দেখতে উপরের 'লাইভ পত্রিকা' ট্যাবে চাপুন।",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(12.dp))
                                Button(onClick = { selectedTab = 0 }) {
                                    Text("লাইভ ওয়েবসাইটে যান 🌐")
                                }
                            }
                        }
                    }
                } else {
                    items(articles, key = { it.id }) { article ->
                        ArticleCard(
                            article = article,
                            onClick = { onOpenArticle(article.id) },
                            onToggleSave = { viewModel.toggleSaveArticle(article) }
                        )
                    }
                }
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            webViewInstance?.destroy()
        }
    }
}
