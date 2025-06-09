package com.devfares.weatherappcompose.di

import com.devfares.weatherappcompose.data.repository.WeatherRepositoryImpl
import com.devfares.weatherappcompose.data.util.WeatherTimeRangeProvider
import com.devfares.weatherappcompose.domain.repository.WeatherRepository
import com.google.android.gms.location.LocationServices
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType.Application.Json
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val appModule = module {
    single { LocationServices.getFusedLocationProviderClient(androidApplication()) }
    single {
        HttpClient(Android) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            install(Logging) {
                level = LogLevel.BODY
            }
        }
    }

    single { WeatherTimeRangeProvider() }
    single<WeatherRepository> { WeatherRepositoryImpl(get(),get()) }
}
