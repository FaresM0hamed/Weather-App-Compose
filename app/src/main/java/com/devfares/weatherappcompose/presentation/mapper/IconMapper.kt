package com.devfares.weatherappcompose.presentation.mapper

import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition

fun WeatherCondition.toDrawableRes(isDay: Boolean): Int {
    return when (this to isDay) {
        WeatherCondition.CLEAR to true -> R.drawable.light_clear_sky
        WeatherCondition.CLEAR to false -> R.drawable.night_clear_sky

        WeatherCondition.MAINLY_CLEAR to true -> R.drawable.light_mainly_clear
        WeatherCondition.MAINLY_CLEAR to false -> R.drawable.night_mainly_clear

        WeatherCondition.PARTLY_CLOUDY to true -> R.drawable.light_partialy_cloudy
        WeatherCondition.PARTLY_CLOUDY to false -> R.drawable.night_partly_cloudy

        WeatherCondition.OVERCAST_CLOUDS to true -> R.drawable.light_overcast
        WeatherCondition.OVERCAST_CLOUDS to false -> R.drawable.night_overcast

        WeatherCondition.FOG to true -> R.drawable.light_fog
        WeatherCondition.FOG to false -> R.drawable.night_fog

        WeatherCondition.DEPOSITING_RIME_FOG to true -> R.drawable.light_rime_fog
        WeatherCondition.DEPOSITING_RIME_FOG to false -> R.drawable.night_rime_fog

        WeatherCondition.DRIZZLE_LIGHT to true -> R.drawable.light_drizzle_light
        WeatherCondition.DRIZZLE_LIGHT to false -> R.drawable.night_drizzle_light

        WeatherCondition.DRIZZLE_MODERATE to true -> R.drawable.light_drizzle_moderate
        WeatherCondition.DRIZZLE_MODERATE to false -> R.drawable.night_drizzle_moderate

        WeatherCondition.DRIZZLE_DENSE_INTENSITY to true -> R.drawable.light_drizzle_intensity
        WeatherCondition.DRIZZLE_DENSE_INTENSITY to false -> R.drawable.night_drizzle_intensity

        WeatherCondition.FREEZING_DRIZZLE_LIGHT to true -> R.drawable.light_freezing_drizzle_light
        WeatherCondition.FREEZING_DRIZZLE_LIGHT to false -> R.drawable.night_freezing_drizzle_light

        WeatherCondition.FREEZING_DRIZZLE_DENSE_INTENSITY to true -> R.drawable.light_freezing_drizzle_intensity
        WeatherCondition.FREEZING_DRIZZLE_DENSE_INTENSITY to false -> R.drawable.night_freezing_drizzle_intensity

        WeatherCondition.RAIN_SLIGHT to true -> R.drawable.light_rain_slight
        WeatherCondition.RAIN_SLIGHT to false -> R.drawable.night_rain_slight

        WeatherCondition.RAIN_MODERATE to true -> R.drawable.light_rain_moderate
        WeatherCondition.RAIN_MODERATE to false -> R.drawable.night_rain_moderate

        WeatherCondition.RAIN_HEAVY_INTENSITY to true -> R.drawable.light_rain_slight
        WeatherCondition.RAIN_HEAVY_INTENSITY to false -> R.drawable.night_rain_slight

        WeatherCondition.FREEZING_RAIN_SLIGHT to true -> R.drawable.light_freezing_rain_light
        WeatherCondition.FREEZING_RAIN_SLIGHT to false -> R.drawable.night_freezing_rain_light

        WeatherCondition.FREEZING_RAIN_HIGH_INTENSITY to true -> R.drawable.light_freezing_drizzle_intensity
        WeatherCondition.FREEZING_RAIN_HIGH_INTENSITY to false -> R.drawable.night_freezing_drizzle_intensity

        WeatherCondition.SNOW_SLIGHT to true -> R.drawable.light_snow_fall_light
        WeatherCondition.SNOW_SLIGHT to false -> R.drawable.night_snowfall_slight

        WeatherCondition.SNOW_MODERATE to true -> R.drawable.light_snow_fall_moderate
        WeatherCondition.SNOW_MODERATE to false -> R.drawable.night_snowfall_moderate

        WeatherCondition.SNOW_HEAVY_INTENSITY to true -> R.drawable.light_snowfall_heavy
        WeatherCondition.SNOW_HEAVY_INTENSITY to false -> R.drawable.night_snowfall_heavy

        WeatherCondition.SNOW_GRAINS to true -> R.drawable.light_snow_grains
        WeatherCondition.SNOW_GRAINS to false -> R.drawable.night_snow_grains

        WeatherCondition.RAIN_SHOWERS_SLIGHT to true -> R.drawable.light_rain_shower_slight
        WeatherCondition.RAIN_SHOWERS_SLIGHT to false -> R.drawable.night_rain_shower_slight

        WeatherCondition.RAIN_SHOWERS_MODERATE to true -> R.drawable.light_rain_shower_moderate
        WeatherCondition.RAIN_SHOWERS_MODERATE to false -> R.drawable.night_rain_shower_moderate

        WeatherCondition.RAIN_SHOWERS_HEAVY_INTENSITY to true -> R.drawable.light_rain_shower_violent
        WeatherCondition.RAIN_SHOWERS_HEAVY_INTENSITY to false -> R.drawable.night_rain_shower_violent

        WeatherCondition.SNOW_SHOWERS_SLIGHT to true -> R.drawable.light_snow_shower_slight
        WeatherCondition.SNOW_SHOWERS_SLIGHT to false -> R.drawable.night_snow_shower_slight

        WeatherCondition.SNOW_SHOWERS_HEAVY_INTENSITY to true -> R.drawable.light_snow_shower_heavy
        WeatherCondition.SNOW_SHOWERS_HEAVY_INTENSITY to false -> R.drawable.night_snow_shower_heavy

        WeatherCondition.THUNDERSTORM_LIGHT to true -> R.drawable.light_thunderstorm_with_slight_hail
        WeatherCondition.THUNDERSTORM_LIGHT to false -> R.drawable.night_thunderstorm_with_slight_hail

        WeatherCondition.THUNDERSTORM_MODERATE to true -> R.drawable.light_thunderstorm_moderate
        WeatherCondition.THUNDERSTORM_MODERATE to false -> R.drawable.night_thunderstorm_moderate

        WeatherCondition.THUNDERSTORM_HEAVY_INTENSITY to true -> R.drawable.light_thunderstrom_with_heavy_hail
        WeatherCondition.THUNDERSTORM_HEAVY_INTENSITY to false -> R.drawable.night_thunderstrom_with_heavy_hail

        else -> R.drawable.light_clear_sky
    }
}
