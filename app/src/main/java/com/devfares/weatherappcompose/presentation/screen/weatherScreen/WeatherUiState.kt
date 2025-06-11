package com.devfares.weatherappcompose.presentation.screen.weatherScreen

import com.devfares.weatherappcompose.domain.entity.DailyForecast
import com.devfares.weatherappcompose.domain.entity.HourlyForecast
import com.devfares.weatherappcompose.domain.entity.Weather
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition
import java.time.format.TextStyle
import java.util.Locale

data class WeatherUiState(
    val isLoading: Boolean = true,
    val errorMessage: String? = null,
    val cityName: String = "Cairo",
    val currentTemperature: String = "20°C",
    val minimumTemperature: String = "15°C",
    val maximumTemperature: String = "30°C",
    val feelsLikeTemperature: String = "29°C",
    val condition: WeatherCondition = WeatherCondition.MAINLY_CLEAR,
    val humidityPercentage: String = "30%",
    val rainPercentage: String = "2%",
    val windSpeed: String = "10 km/h",
    val surfacePressure: String = "1013 hPa",
    val ultravioletIndex: String = "0",
    val isDay: Boolean = true,
    val dailyForecast: List<DailyForecastUiState> = List(7) { DailyForecastUiState() },
    val hourlyForecast: List<HourlyForecastUiState> = List(24) { HourlyForecastUiState() }
)



data class DailyForecastUiState(
    val dayName: String = "Monday",
    val minimumTemperature: String = "18°C",
    val maximumTemperature: String = "25°C",
    val weatherCondition: WeatherCondition = WeatherCondition.CLEAR
)


data class HourlyForecastUiState(
    val isDay: Boolean = true,
    val time: String = "12:00",
    val temperature: String = "22°C",
    val weatherCondition: WeatherCondition = WeatherCondition.CLEAR
)


fun Weather.toUiState(): WeatherUiState {
    return WeatherUiState(
        cityName = cityName,
        currentTemperature = "${currentTemperature.toInt().toString().format(1)}°C",
        minimumTemperature = "${minimumTemperature.toInt().toString().format(1)}°C",
        maximumTemperature = "${maximumTemperature.toInt().toString().format(1)}°C",
        feelsLikeTemperature = "${feelsLikeTemperature.toInt().toString().format(1)}°C",
        condition = condition,
        humidityPercentage = "$humidityPercentage%",
        rainPercentage = "$rainPercentage%",
        windSpeed = "$windSpeed km/h",
        surfacePressure = "$surfacePressure hPa",
        ultravioletIndex = ultravioletIndex.toString(),
        isDay = isDay,
        dailyForecast = dailyForecast.map { it.toUiState() },
        hourlyForecast = hourlyForecast.map { it.toUiState() }
    )
}

fun DailyForecast.toUiState(): DailyForecastUiState {
    return DailyForecastUiState(
        dayName = date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH),
        minimumTemperature = "${minimumTemperature.toInt().toString().format(1)}°C",
        maximumTemperature = "${maximumTemperature.toInt().toString().format(1)}°C",
        weatherCondition = weatherCondition
    )
}

fun HourlyForecast.toUiState(): HourlyForecastUiState {
    return HourlyForecastUiState(
        isDay = isDay,
        time = "${time.hour.toString().padStart(2, '0')}:${
            time.minute.toString().padStart(2, '0')
        }",
        temperature = "${temperature.toInt().toString().format(1)}°C",
        weatherCondition = weatherCondition
    )
}