package com.devfares.weatherappcompose.data.mapper

import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition

fun mapWeatherCodeToCondition(code: Int): WeatherCondition {
    return when (code) {
        0 -> WeatherCondition.CLEAR
        1 -> WeatherCondition.MAINLY_CLEAR
        2 -> WeatherCondition.PARTLY_CLOUDY
        3 -> WeatherCondition.OVERCAST_CLOUDS
        45 -> WeatherCondition.FOG
        48 -> WeatherCondition.DEPOSITING_RIME_FOG
        51 -> WeatherCondition.DRIZZLE_LIGHT
        53 -> WeatherCondition.DRIZZLE_MODERATE
        55 -> WeatherCondition.DRIZZLE_DENSE_INTENSITY
        56 -> WeatherCondition.FREEZING_DRIZZLE_LIGHT
        57 -> WeatherCondition.FREEZING_DRIZZLE_DENSE_INTENSITY
        61 -> WeatherCondition.RAIN_SLIGHT
        63 -> WeatherCondition.RAIN_MODERATE
        65 -> WeatherCondition.RAIN_HEAVY_INTENSITY
        66 -> WeatherCondition.FREEZING_RAIN_SLIGHT
        67 -> WeatherCondition.FREEZING_RAIN_HIGH_INTENSITY
        71 -> WeatherCondition.SNOW_SLIGHT
        73 -> WeatherCondition.SNOW_MODERATE
        75 -> WeatherCondition.SNOW_HEAVY_INTENSITY
        77 -> WeatherCondition.SNOW_GRAINS
        80 -> WeatherCondition.RAIN_SHOWERS_SLIGHT
        81 -> WeatherCondition.RAIN_SHOWERS_MODERATE
        82 -> WeatherCondition.RAIN_SHOWERS_HEAVY_INTENSITY
        85 -> WeatherCondition.SNOW_SHOWERS_SLIGHT
        86 -> WeatherCondition.SNOW_SHOWERS_HEAVY_INTENSITY
        95 -> WeatherCondition.THUNDERSTORM_LIGHT
        96 -> WeatherCondition.THUNDERSTORM_MODERATE
        99 -> WeatherCondition.THUNDERSTORM_HEAVY_INTENSITY
        else -> WeatherCondition.CLEAR
    }
}