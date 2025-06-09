package com.devfares.weatherappcompose.domain.useCase

import com.devfares.weatherappcompose.domain.entity.Location
import com.devfares.weatherappcompose.domain.entity.Weather
import com.devfares.weatherappcompose.domain.repository.LocationRepository
import com.devfares.weatherappcompose.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository
) {
    suspend fun fdf9(){
        val location = locationRepository.getCurrentLocation()
        weatherRepository.getWeatherByCoordinates(location)
    }
}