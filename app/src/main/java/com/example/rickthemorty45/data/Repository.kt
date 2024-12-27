package com.example.rickthemorty45.data

import android.util.Log
import com.example.rickthemorty45.data.models.CharacterResponse
import com.example.rickthemorty45.data.models.EpisodeResponse
import com.example.rickthemorty45.data.models.LocationResponse
import retrofit2.Response

class Repository(private val apiService: ApiService) {

    suspend fun getCharacterById(id: Int) = apiService.getCharacterById(id)

    suspend fun getLocationById(id: Int) = apiService.getLocationById(id)

    suspend fun getCharacters(page: Int): CharacterResponse {
        return apiService.getCharacters(page)
    }

    suspend fun getLocations(page: Int): Response<LocationResponse> {
        val response = apiService.getLocations(page)
        if (!response.isSuccessful) {
            Log.e("Repository", "Failed to fetch locations: ${response.code()} ${response.message()}")
        }
        return response
    }

    suspend fun getEpisodes(page: Int): Response<EpisodeResponse> {
        return apiService.getEpisodes(page)
    }
}