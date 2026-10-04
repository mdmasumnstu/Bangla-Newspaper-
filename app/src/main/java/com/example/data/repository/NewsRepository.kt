package com.example.data.repository

import android.content.Context
import com.example.data.local.NewsDatabase
import com.example.data.local.entity.ArticleEntity
import com.example.data.local.entity.FavoriteNewspaperEntity
import com.example.data.model.InitialNewsData
import com.example.data.model.Newspaper
import com.example.data.model.NewspaperDataSource
import com.example.data.network.RssFeedFetcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class NewsRepository(
    private val database: NewsDatabase,
    private val rssFetcher: RssFeedFetcher = RssFeedFetcher()
) {
    private val articleDao = database.articleDao()
    private val favoriteNewspaperDao = database.favoriteNewspaperDao()

    val allArticles: Flow<List<ArticleEntity>> = articleDao.getAllArticles()
    val topNews: Flow<List<ArticleEntity>> = articleDao.getTopNews()
    val breakingNews: Flow<List<ArticleEntity>> = articleDao.getBreakingNews()
    val savedArticles: Flow<List<ArticleEntity>> = articleDao.getSavedArticles()
    val favoriteNewspaperIds: Flow<List<String>> = favoriteNewspaperDao.getFavoriteNewspaperIds()

    suspend fun initializeData(context: Context? = null) = withContext(Dispatchers.IO) {
        val prefs = context?.getSharedPreferences("newshub_bd_prefs", Context.MODE_PRIVATE)
        val isInitialized = prefs?.getBoolean("db_seed_initialized", false) ?: false
        if (!isInitialized) {
            val count = articleDao.getCount()
            if (count < 50) {
                articleDao.insertArticles(InitialNewsData.seedArticles)
                // Pre-favorite a couple prominent newspapers for a welcoming initial state
                favoriteNewspaperDao.insertFavorite(FavoriteNewspaperEntity("prothom_alo"))
                favoriteNewspaperDao.insertFavorite(FavoriteNewspaperEntity("the_daily_star"))
            }
            prefs?.edit()?.putBoolean("db_seed_initialized", true)?.apply()
        }
    }

    suspend fun refreshRealtimeNews(): Result<Int> = withContext(Dispatchers.IO) {
        try {
            val priorityIds = setOf("prothom_alo", "the_daily_star", "bdnews24", "dhaka_tribune", "jugantor", "kaler_kantho", "ittefaq", "bangla_tribune")
            val allCandidates = NewspaperDataSource.allNewspapers.filter { it.rssUrl != null }
            val candidates = allCandidates.filter { it.id in priorityIds }.ifEmpty { allCandidates.take(6) }
            val fetchedArticles = rssFetcher.fetchAllRealtime(candidates)
            if (fetchedArticles.isNotEmpty()) {
                // Ensure balanced insertion across all newspapers without wiping diverse local and national news
                val balancedArticles = fetchedArticles
                    .groupBy { it.newspaperId }
                    .flatMap { (_, list) -> list.take(3) }
                articleDao.insertArticles(balancedArticles)
                Result.success(balancedArticles.size)
            } else {
                Result.success(0)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getArticlesByNewspaper(newspaperId: String): Flow<List<ArticleEntity>> {
        return articleDao.getArticlesByNewspaper(newspaperId)
    }

    fun getArticlesByCategory(category: String): Flow<List<ArticleEntity>> {
        return articleDao.getArticlesByCategory(category)
    }

    fun searchArticles(query: String): Flow<List<ArticleEntity>> {
        return articleDao.searchArticles(query)
    }

    fun getArticleById(id: String): Flow<ArticleEntity?> {
        return articleDao.getArticleById(id)
    }

    suspend fun getArticleByIdDirect(id: String): ArticleEntity? = withContext(Dispatchers.IO) {
        articleDao.getArticleByIdDirect(id)
    }

    suspend fun toggleSaveArticle(id: String, save: Boolean) = withContext(Dispatchers.IO) {
        articleDao.updateSavedStatus(
            id = id,
            isSaved = save,
            savedAt = if (save) System.currentTimeMillis() else 0L
        )
    }

    suspend fun toggleFavoriteNewspaper(newspaperId: String, isCurrentlyFavorite: Boolean) = withContext(Dispatchers.IO) {
        if (isCurrentlyFavorite) {
            favoriteNewspaperDao.removeFavorite(newspaperId)
        } else {
            favoriteNewspaperDao.insertFavorite(FavoriteNewspaperEntity(newspaperId))
        }
    }

    suspend fun clearCache() = withContext(Dispatchers.IO) {
        articleDao.clearNonSavedCache()
        articleDao.insertArticles(InitialNewsData.seedArticles)
    }

    companion object {
        @Volatile
        private var INSTANCE: NewsRepository? = null

        fun getInstance(context: Context): NewsRepository {
            return INSTANCE ?: synchronized(this) {
                val db = NewsDatabase.getInstance(context)
                val instance = NewsRepository(db)
                INSTANCE = instance
                instance
            }
        }
    }
}
