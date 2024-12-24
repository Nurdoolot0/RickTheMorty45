package com.example.rickthemorty45.data.local.dao

import androidx.room.*
import com.example.rickthemorty45.data.local.entities.FavoriteCharacter
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCharacterDao {
    @Query("SELECT * FROM favorite_characters")
    fun getFavoriteCharacters(): Flow<List<FavoriteCharacter>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorites(character: FavoriteCharacter)

    @Query("DELETE FROM favorite_characters WHERE id = :characterId")
    suspend fun removeFromFavorites(characterId: Int)
}