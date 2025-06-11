package com.devfares.weatherappcompose.di

import com.devfares.weatherappcompose.data.util.WeatherTimeRangeProvider
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val utilityModule =
    module {
        singleOf(::WeatherTimeRangeProvider)
        single { LocationServices.getFusedLocationProviderClient(androidApplication()) }

    }