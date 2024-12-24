package com.example.rickthemorty45.data

import com.example.rickthemorty45.data.models.CharacterResponse
import com.example.rickthemorty45.data.models.LocationResponse
import retrofit2.Response

class Repository(private val apiService: ApiService) {
    suspend fun getCharacterById(id: Int) = apiService.getCharacterById(id)
    suspend fun getLocationById(id: Int) = apiService.getLocationById(id)
    suspend fun getCharacters(page: Int): Response<CharacterResponse> {
        return apiService.getCharacters(page)
    }

    suspend fun getLocations(): Response<LocationResponse> {

        return apiService.getLocations()
    }
}