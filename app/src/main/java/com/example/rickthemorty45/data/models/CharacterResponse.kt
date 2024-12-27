package com.example.rickthemorty45.data.models

data class CharacterResponse(
    val info: Info,
    val results: List<Character>
) {
    data class Info(
        val count: Int,
        val pages: Int,
        val next: String?,
        val prev: String?
    )

    data class Character(
        val id: Int,
        val name: String,
        val species: String,
        val image: String,
        val isFavorite: Boolean = false,
        val status: String
    )
}