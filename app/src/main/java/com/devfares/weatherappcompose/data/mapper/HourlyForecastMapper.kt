package com.devfares.weatherappcompose.data.mapper

import com.devfares.weatherappcompose.data.model.HourlyWeatherDTO
import com.devfares.weatherappcompose.domain.entity.HourlyForecast
import kotlinx.datetime.LocalDateTime

fun HourlyWeatherDTO.toHourlyForecast():List<HourlyForecast>{
    return time.mapIndexed{ index , time ->
        HourlyForecast(
            isDay = isDay[index] == 1,
            time = LocalDateTime.parse(time),
            temperature = temperature[index],
            weatherCondition = mapWeatherCodeToCondition(weatherCode[index])
        )
    }
}