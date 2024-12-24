package com.example.rickthemorty45.data.repository

import android.util.Log
import com.example.rickthemorty45.data.ApiService
import com.example.rickthemorty45.data.models.Episode

class EpisodesRepositoryImpl(private val apiService: ApiService) : EpisodesRepository {
    private var currentPage = 1

    override suspend fun getNextPageEpisodes(): List<Episode> {
        return try {
            val response = apiService.getEpisodes(currentPage)

            if (response.isSuccessful) {
                currentPage++
                response.body()?.results ?: emptyList()
            } else {
                throw Exception("Failed to fetch episodes, response code: ${response.code()}")
            }
        } catch (e: Exception) {
            Log.e("EpisodesRepositoryImpl", "Error fetching episodes", e)
            throw Exception("Failed to fetch episodes due to network or server issue", e)
        }
    }
}