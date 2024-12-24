package com.example.rickthemorty45.data.repository

import com.example.rickthemorty45.data.models.Episode

interface EpisodesRepository {
    suspend fun getNextPageEpisodes(): List<Episode>
}