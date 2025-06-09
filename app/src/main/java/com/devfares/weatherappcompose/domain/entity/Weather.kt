package com.devfares.weatherappcompose.domain.entity

import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition

/**
 * Question : Based on Business Requirements (Build one screen)
 * I decided to bundle daily and hourly forecasts with the weather data to work with cohesive object,
 * else i would make it in separate entities , is this correct ?
 * */

data class Weather(
    val cityName: String,
    val currentTemperature: Double,
    val minimumTemperature: Double,
    val maximumTemperature: Double,
    val feelsLikeTemperature: Double,
    val condition: WeatherCondition,
    val humidityPercentage: Int,
    val rainPercentage: Int,
    val windSpeed: Int,
    val surfacePressure: Int,
    val ultravioletIndex: Int,
    val isDay: Boolean = true,
    val dailyForecast: List<DailyForecast>,
    val hourlyForecast: List<HourlyForecast>
)




