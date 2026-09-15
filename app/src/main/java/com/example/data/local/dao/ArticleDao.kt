package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles ORDER BY publishedAt DESC")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM articles WHERE isTopNews = 1 ORDER BY publishedAt DESC")
    fun getTopNews(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM articles WHERE isBreaking = 1 ORDER BY publishedAt DESC")
    fun getBreakingNews(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM articles WHERE isSaved = 1 ORDER BY savedAt DESC")
    fun getSavedArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM articles WHERE newspaperId = :newspaperId ORDER BY publishedAt DESC")
    fun getArticlesByNewspaper(newspaperId: String): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM articles WHERE category = :category ORDER BY publishedAt DESC")
    fun getArticlesByCategory(category: String): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM articles WHERE id = :id LIMIT 1")
    fun getArticleById(id: String): Flow<ArticleEntity?>

    @Query("SELECT * FROM articles WHERE id = :id LIMIT 1")
    suspend fun getArticleByIdDirect(id: String): ArticleEntity?

    @Query("SELECT * FROM articles WHERE title LIKE '%' || :query || '%' OR description LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%' OR newspaperName LIKE '%' || :query || '%' ORDER BY publishedAt DESC")
    fun searchArticles(query: String): Flow<List<ArticleEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles: List<ArticleEntity>)

    @Query("UPDATE articles SET isSaved = :isSaved, savedAt = :savedAt WHERE id = :id")
    suspend fun updateSavedStatus(id: String, isSaved: Boolean, savedAt: Long)

    @Query("SELECT COUNT(*) FROM articles")
    suspend fun getCount(): Int

    @Query("SELECT COUNT(*) FROM articles WHERE id NOT LIKE 'seed_%' AND id NOT LIKE 'breaking_%' AND id NOT LIKE 'top_%' AND id NOT LIKE 'article_%'")
    suspend fun getRealtimeArticleCount(): Int

    @Query("DELETE FROM articles WHERE isSaved = 0 AND (id LIKE 'seed_%' OR id LIKE 'breaking_%' OR id LIKE 'top_%' OR id LIKE 'article_%')")
    suspend fun clearNonSavedSeedArticles()

    @Query("DELETE FROM articles WHERE isSaved = 0")
    suspend fun clearNonSavedCache()
}
