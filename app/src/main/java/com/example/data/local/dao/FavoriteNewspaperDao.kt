package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.FavoriteNewspaperEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteNewspaperDao {
    @Query("SELECT newspaperId FROM favorite_newspapers")
    fun getFavoriteNewspaperIds(): Flow<List<String>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(entity: FavoriteNewspaperEntity)

    @Query("DELETE FROM favorite_newspapers WHERE newspaperId = :newspaperId")
    suspend fun removeFavorite(newspaperId: String)

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_newspapers WHERE newspaperId = :newspaperId)")
    fun isFavorite(newspaperId: String): Flow<Boolean>
}
