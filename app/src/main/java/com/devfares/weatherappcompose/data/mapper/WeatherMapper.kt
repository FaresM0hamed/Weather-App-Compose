package com.devfares.weatherappcompose.data.mapper

import com.devfares.weatherappcompose.data.model.WeatherResponseDTO
import com.devfares.weatherappcompose.domain.entity.Weather

fun WeatherResponseDTO.toWeather(cityName:String): Weather {
    return Weather(
        cityName = cityName,
        currentTemperature = currentWeather.currentTemperature,
        minimumTemperature = dailyForecast.minimumTemperature[0],
        maximumTemperature = dailyForecast.maximumTemperature[0],
        feelsLikeTemperature = currentWeather.feelsLikeTemperature,
        condition = mapWeatherCodeToCondition(currentWeather.weatherCode),
        humidityPercentage = currentWeather.humidityPercentage,
        rainPercentage = currentWeather.rainPercentage,
        windSpeed = currentWeather.windSpeed.toInt(),
        surfacePressure = currentWeather.surfacePressure.toInt(),
        ultravioletIndex = currentWeather.ultravioletIndex.toInt(),
        dailyForecast = dailyForecast.toDailyForecast(),
        hourlyForecast = hourlyForecast.toHourlyForecast(),
        isDay = currentWeather.isDay == 1
    )
}