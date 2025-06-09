package com.devfares.weatherappcompose.data.mapper

import com.devfares.weatherappcompose.data.model.DailyWeatherDTO
import com.devfares.weatherappcompose.domain.entity.DailyForecast
import kotlinx.datetime.LocalDate


fun DailyWeatherDTO.toDailyForecast(): List<DailyForecast> {
    return date.mapIndexed { index, date ->
        DailyForecast(
            date = LocalDate.parse(date),
            minimumTemperature = minimumTemperature[index],
            maximumTemperature = maximumTemperature[index],
            weatherCondition = mapWeatherCodeToCondition(weatherCode[index])
        )
    }
}
