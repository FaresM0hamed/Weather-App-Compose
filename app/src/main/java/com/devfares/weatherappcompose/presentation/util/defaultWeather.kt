package com.devfares.weatherappcompose.presentation.util

import com.devfares.weatherappcompose.domain.entity.Weather
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition

fun mockWeather(): Weather {
    return Weather(
        cityName = "Unknown",
        currentTemperature = 0.0,
        minimumTemperature = 0.0,
        maximumTemperature = 0.0,
        feelsLikeTemperature = 0.0,
        condition = WeatherCondition.CLEAR,
        humidityPercentage = 0,
        rainPercentage = 0,
        windSpeed = 0,
        surfacePressure = 0,
        ultravioletIndex = 0,
        isDay = true,
        dailyForecast = emptyList(),
        hourlyForecast = emptyList()
    )
}
