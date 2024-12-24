package com.example.rickthemorty45.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.rickthemorty45.data.ApiService
import com.example.rickthemorty45.data.Repository
import com.example.rickthemorty45.data.local.database.AppDatabase
import com.example.rickthemorty45.data.repository.EpisodesRepository
import com.example.rickthemorty45.data.repository.EpisodesRepositoryImpl
import com.example.rickthemorty45.data.repository.FavoriteCharacterRepository
import com.example.rickthemorty45.ui.characters.CharacterDetailViewModel
import com.example.rickthemorty45.ui.characters.CharactersViewModel
import com.example.rickthemorty45.ui.episodes.EpisodesViewModel
import com.example.rickthemorty45.ui.favorites.FavoriteCharacterViewModel
import com.example.rickthemorty45.ui.locations.LocationDetailViewModel
import com.example.rickthemorty45.ui.locations.LocationsViewModel
import org.koin.android.ext.koin.androidContext

object AppModule {
    val module = module {
        single {
            Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

        single { AppDatabase.getDatabase(androidContext()) }
        single { get<AppDatabase>().favoriteCharacterDao() }
        single { FavoriteCharacterRepository(get()) }
        single<EpisodesRepository> { EpisodesRepositoryImpl(get()) }
        single { Repository(get()) }

        viewModel { FavoriteCharacterViewModel(get()) }
        viewModel { CharactersViewModel(get(), get()) }
        viewModel { LocationsViewModel(get()) }
        viewModel { CharacterDetailViewModel(get()) }
        viewModel { LocationDetailViewModel(get()) }
        viewModel { EpisodesViewModel(get()) }
    }
}