package com.devfares.weatherappcompose.domain.repository

import com.devfares.weatherappcompose.domain.entity.UserLocation
import com.devfares.weatherappcompose.domain.entity.Weather

interface WeatherRepository {
    suspend fun getWeatherByCoordinates(userLocation: UserLocation): Weather
}