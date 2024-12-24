package com.example.rickthemorty45.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_characters")
data class FavoriteCharacter(
    @PrimaryKey val id: Int,
    val name: String,
    val species: String,
    val image: String,
    val status: String,
    val isFavorite: Int = 0
)
