package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.local.dao.ArticleDao
import com.example.data.local.dao.FavoriteNewspaperDao
import com.example.data.local.entity.ArticleEntity
import com.example.data.local.entity.FavoriteNewspaperEntity

@Database(
    entities = [ArticleEntity::class, FavoriteNewspaperEntity::class],
    version = 1,
    exportSchema = false
)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao
    abstract fun favoriteNewspaperDao(): FavoriteNewspaperDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDatabase? = null

        fun getInstance(context: Context): NewsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "newshub_bd.db"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
