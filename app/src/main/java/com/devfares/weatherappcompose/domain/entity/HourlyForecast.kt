package com.devfares.weatherappcompose.domain.entity

import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

data class HourlyForecast(
    val isDay: Boolean,
    val time: LocalDateTime,
    val temperature: Double,
    val weatherCondition: WeatherCondition,
)