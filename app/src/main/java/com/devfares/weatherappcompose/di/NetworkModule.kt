package com.devfares.weatherappcompose.di

import com.devfares.weatherappcompose.data.util.Constants.WEATHER_API_URL
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val netWorkModule =
    module {
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
        single { WEATHER_API_URL }


    }