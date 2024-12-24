package com.example.rickthemorty45

import android.app.Application
import com.example.rickthemorty45.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class RickAndMortyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyApplication)
            modules(AppModule.module)
        }
    }
}