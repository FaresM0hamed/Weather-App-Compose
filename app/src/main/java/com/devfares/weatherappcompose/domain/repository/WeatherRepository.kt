package com.devfares.weatherappcompose.domain.repository

import com.devfares.weatherappcompose.domain.entity.Location
import com.devfares.weatherappcompose.domain.entity.Weather

interface WeatherRepository {
    suspend fun getWeatherByCoordinates(location: Location): Weather
}