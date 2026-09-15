package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_newspapers")
data class FavoriteNewspaperEntity(
    @PrimaryKey
    val newspaperId: String,
    val addedAt: Long = System.currentTimeMillis()
)
