package com.devfares.weatherappcompose.domain.entity

import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition
import kotlinx.datetime.LocalDate

data class DailyForecast(
    val date: LocalDate,
    val minimumTemperature: Double,
    val maximumTemperature: Double,
    val weatherCondition: WeatherCondition,
)