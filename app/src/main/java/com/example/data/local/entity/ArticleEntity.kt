package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleEntity(
    @PrimaryKey
    val id: String,
    val newspaperId: String,
    val newspaperName: String,
    val newspaperBanglaName: String,
    val title: String,
    val description: String,
    val content: String,
    val articleUrl: String,
    val imageUrl: String,
    val category: String,
    val publishedAt: Long,
    val formattedTime: String,
    val isTopNews: Boolean = false,
    val isBreaking: Boolean = false,
    val isSaved: Boolean = false,
    val savedAt: Long = 0L
)
