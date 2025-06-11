package com.devfares.weatherappcompose.di

import com.devfares.weatherappcompose.data.repository.LocationRepositoryImpl
import com.devfares.weatherappcompose.data.repository.WeatherRepositoryImpl
import com.devfares.weatherappcompose.domain.repository.LocationRepository
import com.devfares.weatherappcompose.domain.repository.WeatherRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule= module {
    singleOf(::WeatherRepositoryImpl) bind WeatherRepository::class
    singleOf(::LocationRepositoryImpl) bind LocationRepository::class
}