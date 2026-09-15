package com.example.data.model

data class Newspaper(
    val id: String,
    val name: String,
    val banglaName: String,
    val category: NewspaperCategory,
    val websiteUrl: String,
    val rssUrl: String? = null,
    val tagline: String,
    val primaryColorHex: Long = 0xFF0D6838,
    val isFavorite: Boolean = false
)
