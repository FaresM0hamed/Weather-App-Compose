package com.devfares.weatherappcompose.presentation.mapper

import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.domain.entity.Weather
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition

fun Weather.toDrawableRes(isDay:Boolean): Int {
    return when (Pair(this.condition, isDay)) {
        Pair(WeatherCondition.CLEAR, true) -> R.drawable.light_clear_sky
        Pair(WeatherCondition.CLEAR, false) -> R.drawable.night_clear_sky
        Pair(WeatherCondition.MAINLY_CLEAR, true) -> R.drawable.light_mainly_clear
        Pair(WeatherCondition.MAINLY_CLEAR, false) -> R.drawable.night_mainly_clear
        Pair(WeatherCondition.PARTLY_CLOUDY, true) -> R.drawable.light_partialy_cloudy
        Pair(WeatherCondition.PARTLY_CLOUDY, false) -> R.drawable.night_partly_cloudy
        Pair(WeatherCondition.OVERCAST_CLOUDS, true) -> R.drawable.light_overcast
        Pair(WeatherCondition.OVERCAST_CLOUDS, false) -> R.drawable.night_overcast
        Pair(WeatherCondition.FOG, true) -> R.drawable.light_fog
        Pair(WeatherCondition.FOG, false) -> R.drawable.night_fog
        Pair(WeatherCondition.DEPOSITING_RIME_FOG, true) -> R.drawable.light_rime_fog
        Pair(WeatherCondition.DEPOSITING_RIME_FOG, false) -> R.drawable.night_rime_fog
        Pair(WeatherCondition.DRIZZLE_LIGHT, true) -> R.drawable.light_drizzle_light
        Pair(WeatherCondition.DRIZZLE_LIGHT, false) -> R.drawable.night_drizzle_light
        Pair(WeatherCondition.DRIZZLE_MODERATE, true) -> R.drawable.light_drizzle_moderate
        Pair(WeatherCondition.DRIZZLE_MODERATE, false) -> R.drawable.night_drizzle_moderate
        Pair(WeatherCondition.DRIZZLE_DENSE_INTENSITY, true) -> R.drawable.light_drizzle_intensity
        Pair(WeatherCondition.DRIZZLE_DENSE_INTENSITY, false) -> R.drawable.night_drizzle_intensity
        Pair(WeatherCondition.FREEZING_DRIZZLE_LIGHT, true) -> R.drawable.light_freezing_drizzle_light
        Pair(WeatherCondition.FREEZING_DRIZZLE_LIGHT, false) -> R.drawable.night_freezing_drizzle_light
        Pair(WeatherCondition.FREEZING_DRIZZLE_DENSE_INTENSITY, true) -> R.drawable.light_freezing_drizzle_intensity
        Pair(WeatherCondition.FREEZING_DRIZZLE_DENSE_INTENSITY, false) -> R.drawable.night_freezing_drizzle_intensity
        Pair(WeatherCondition.RAIN_SLIGHT, true) -> R.drawable.light_rain_slight
        Pair(WeatherCondition.RAIN_SLIGHT, false) -> R.drawable.night_rain_slight
        Pair(WeatherCondition.RAIN_MODERATE, true) -> R.drawable.light_rain_moderate
        Pair(WeatherCondition.RAIN_MODERATE, false) -> R.drawable.night_rain_moderate
        Pair(WeatherCondition.RAIN_HEAVY_INTENSITY, true) -> R.drawable.light_rain_slight
        Pair(WeatherCondition.RAIN_HEAVY_INTENSITY, false) -> R.drawable.night_rain_slight
        Pair(WeatherCondition.FREEZING_RAIN_SLIGHT, true) -> R.drawable.light_freezing_rain_light
        Pair(WeatherCondition.FREEZING_RAIN_SLIGHT, false) -> R.drawable.night_freezing_rain_light
        Pair(WeatherCondition.FREEZING_RAIN_HIGH_INTENSITY, true) -> R.drawable.light_freezing_drizzle_intensity
        Pair(WeatherCondition.FREEZING_RAIN_HIGH_INTENSITY, false) -> R.drawable.night_freezing_drizzle_intensity
        Pair(WeatherCondition.SNOW_SLIGHT, true) -> R.drawable.light_snow_fall_light
        Pair(WeatherCondition.SNOW_SLIGHT, false) -> R.drawable.night_snowfall_slight
        Pair(WeatherCondition.SNOW_MODERATE, true) -> R.drawable.light_snow_fall_moderate
        Pair(WeatherCondition.SNOW_MODERATE, false) -> R.drawable.night_snowfall_moderate
        Pair(WeatherCondition.SNOW_HEAVY_INTENSITY, true) -> R.drawable.light_snowfall_heavy
        Pair(WeatherCondition.SNOW_HEAVY_INTENSITY, false) -> R.drawable.night_snowfall_heavy
        Pair(WeatherCondition.SNOW_GRAINS, true) -> R.drawable.light_snow_grains
        Pair(WeatherCondition.SNOW_GRAINS, false) -> R.drawable.night_snow_grains
        Pair(WeatherCondition.RAIN_SHOWERS_SLIGHT, true) -> R.drawable.light_rain_shower_slight
        Pair(WeatherCondition.RAIN_SHOWERS_SLIGHT, false) -> R.drawable.night_rain_shower_slight
        Pair(WeatherCondition.RAIN_SHOWERS_MODERATE, true) -> R.drawable.light_rain_shower_moderate
        Pair(WeatherCondition.RAIN_SHOWERS_MODERATE, false) -> R.drawable.night_rain_shower_moderate
        Pair(WeatherCondition.RAIN_SHOWERS_HEAVY_INTENSITY, true) -> R.drawable.light_rain_shower_violent
        Pair(WeatherCondition.RAIN_SHOWERS_HEAVY_INTENSITY, false) -> R.drawable.night_rain_shower_violent
        Pair(WeatherCondition.SNOW_SHOWERS_SLIGHT, true) -> R.drawable.light_snow_shower_slight
        Pair(WeatherCondition.SNOW_SHOWERS_SLIGHT, false) -> R.drawable.night_snow_shower_slight
        Pair(WeatherCondition.SNOW_SHOWERS_HEAVY_INTENSITY, true) -> R.drawable.light_snow_shower_heavy
        Pair(WeatherCondition.SNOW_SHOWERS_HEAVY_INTENSITY, false) -> R.drawable.night_snow_shower_heavy
        Pair(WeatherCondition.THUNDERSTORM_LIGHT, true) -> R.drawable.light_thunderstorm_with_slight_hail
        Pair(WeatherCondition.THUNDERSTORM_LIGHT, false) -> R.drawable.night_thunderstorm_with_slight_hail
        Pair(WeatherCondition.THUNDERSTORM_MODERATE, true) -> R.drawable.light_thunderstorm_moderate
        Pair(WeatherCondition.THUNDERSTORM_MODERATE, false) -> R.drawable.night_thunderstorm_moderate
        Pair(WeatherCondition.THUNDERSTORM_HEAVY_INTENSITY, true) -> R.drawable.light_thunderstrom_with_heavy_hail
        Pair(WeatherCondition.THUNDERSTORM_HEAVY_INTENSITY, false) -> R.drawable.night_thunderstrom_with_heavy_hail

        else -> {R.drawable.light_clear_sky}
    }
}