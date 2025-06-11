package com.devfares.weatherappcompose.presentation.mapper

import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition

fun WeatherCondition.toLocalizedStringRes(): Int {
    return when (this) {
        WeatherCondition.CLEAR -> R.string.clear_sky
        WeatherCondition.MAINLY_CLEAR -> R.string.mainly_clear
        WeatherCondition.PARTLY_CLOUDY -> R.string.partly_cloudy
        WeatherCondition.OVERCAST_CLOUDS -> R.string.overcast
        WeatherCondition.FOG -> R.string.fog
        WeatherCondition.DEPOSITING_RIME_FOG -> R.string.depositing_rime_fog
        WeatherCondition.DRIZZLE_LIGHT -> R.string.light_drizzle
        WeatherCondition.DRIZZLE_MODERATE -> R.string.moderate_drizzle
        WeatherCondition.DRIZZLE_DENSE_INTENSITY -> R.string.dense_drizzle
        WeatherCondition.FREEZING_DRIZZLE_LIGHT -> R.string.light_freezing_drizzle
        WeatherCondition.FREEZING_DRIZZLE_DENSE_INTENSITY -> R.string.dense_freezing_drizzle
        WeatherCondition.RAIN_SLIGHT -> R.string.slight_rain
        WeatherCondition.RAIN_MODERATE -> R.string.moderate_rain
        WeatherCondition.RAIN_HEAVY_INTENSITY -> R.string.heavy_rain
        WeatherCondition.FREEZING_RAIN_SLIGHT -> R.string.light_freezing_rain
        WeatherCondition.FREEZING_RAIN_HIGH_INTENSITY -> R.string.heavy_freezing_rain
        WeatherCondition.SNOW_SLIGHT -> R.string.slight_snow_fall
        WeatherCondition.SNOW_MODERATE -> R.string.moderate_snow_fall
        WeatherCondition.SNOW_HEAVY_INTENSITY -> R.string.heavy_snow_fall
        WeatherCondition.SNOW_GRAINS -> R.string.snow_grains
        WeatherCondition.RAIN_SHOWERS_SLIGHT -> R.string.slight_rain_showers
        WeatherCondition.RAIN_SHOWERS_MODERATE -> R.string.moderate_rain_showers
        WeatherCondition.RAIN_SHOWERS_HEAVY_INTENSITY -> R.string.violent_rain_showers
        WeatherCondition.SNOW_SHOWERS_SLIGHT -> R.string.slight_snow_showers
        WeatherCondition.SNOW_SHOWERS_HEAVY_INTENSITY -> R.string.heavy_snow_showers
        WeatherCondition.THUNDERSTORM_LIGHT -> R.string.slight_or_moderate_thunderstorm
        WeatherCondition.THUNDERSTORM_MODERATE -> R.string.thunderstorm_with_slight_hail
        WeatherCondition.THUNDERSTORM_HEAVY_INTENSITY -> R.string.thunderstorm_with_heavy_hail
    }
}
