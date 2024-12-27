package com.example.rickthemorty45.data

import retrofit2.Response
import retrofit2.http.GET
import com.example.rickthemorty45.data.models.CharacterResponse
import com.example.rickthemorty45.data.models.EpisodeResponse
import com.example.rickthemorty45.data.models.LocationResponse
import retrofit2.http.Query

interface ApiService {

    @GET("location")
    suspend fun getLocations(@Query("page") page: Int): Response<LocationResponse>

    @GET("character/{id}")
    suspend fun getCharacterById(@retrofit2.http.Path("id") id: Int): Response<CharacterResponse.Character>

    @GET("location/{id}")
    suspend fun getLocationById(@retrofit2.http.Path("id") id: Int): Response<LocationResponse.Location>

    @GET("character")
    suspend fun getCharacters(@Query("page") page: Int): CharacterResponse

    @GET("episode")
    suspend fun getEpisodes(@Query("page") page: Int): Response<EpisodeResponse>
}