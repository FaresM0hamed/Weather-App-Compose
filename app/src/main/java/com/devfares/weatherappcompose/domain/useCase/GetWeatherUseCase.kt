package com.devfares.weatherappcompose.domain.useCase

import com.devfares.weatherappcompose.domain.entity.Weather
import com.devfares.weatherappcompose.domain.repository.LocationRepository
import com.devfares.weatherappcompose.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val weatherRepository: WeatherRepository,
    private val locationRepository: LocationRepository
) {
    suspend operator fun invoke(): Weather {
        val location = locationRepository.getCurrentLocation()
        return weatherRepository.getWeatherByCoordinates(location)
    }
}