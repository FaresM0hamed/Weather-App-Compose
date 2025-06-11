package com.devfares.weatherappcompose.data.repository

import com.devfares.weatherappcompose.data.mapper.toWeather
import com.devfares.weatherappcompose.data.model.WeatherResponseDTO
import com.devfares.weatherappcompose.data.util.Constants.CURRENT_WEATHER_PARAMS
import com.devfares.weatherappcompose.data.util.Constants.DAILY_WEATHER_PARAMS
import com.devfares.weatherappcompose.data.util.Constants.HOURLY_WEATHER_PARAMS
import com.devfares.weatherappcompose.data.util.Constants.PARAM_CURRENT
import com.devfares.weatherappcompose.data.util.Constants.PARAM_DAILY
import com.devfares.weatherappcompose.data.util.Constants.PARAM_END_DATE
import com.devfares.weatherappcompose.data.util.Constants.PARAM_END_HOUR
import com.devfares.weatherappcompose.data.util.Constants.PARAM_HOURLY
import com.devfares.weatherappcompose.data.util.Constants.PARAM_LATITUDE
import com.devfares.weatherappcompose.data.util.Constants.PARAM_LONGITUDE
import com.devfares.weatherappcompose.data.util.Constants.PARAM_START_DATE
import com.devfares.weatherappcompose.data.util.Constants.PARAM_START_HOUR
import com.devfares.weatherappcompose.data.util.Constants.PARAM_TIMEZONE
import com.devfares.weatherappcompose.data.util.Constants.PARAM_TIMEZONE_VALUE
import com.devfares.weatherappcompose.data.util.Constants.WEATHER_API_URL
import com.devfares.weatherappcompose.data.util.WeatherTimeRangeProvider
import com.devfares.weatherappcompose.domain.entity.UserLocation
import com.devfares.weatherappcompose.domain.entity.Weather
import com.devfares.weatherappcompose.domain.repository.WeatherRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class WeatherRepositoryImpl(
    private val httpClient: HttpClient,
    private val timeRangeCalculator: WeatherTimeRangeProvider,
    private val weatherApiUrl: String
) : WeatherRepository {

    override suspend fun getWeatherByCoordinates(userLocation: UserLocation): Weather {
        val timeRange = timeRangeCalculator.calculateRange()
        val weatherResponseDTO: WeatherResponseDTO = fetchWeatherData(userLocation, timeRange)
        return weatherResponseDTO.toWeather(userLocation.cityName)
    }

    private suspend fun fetchWeatherData(
        userLocation: UserLocation,
        timeRange: WeatherTimeRangeProvider.TimeRange
    ): WeatherResponseDTO {
        return httpClient.get(weatherApiUrl) {
            parameter(PARAM_LATITUDE, userLocation.latitude)
            parameter(PARAM_LONGITUDE, userLocation.longitude)
            parameter(PARAM_CURRENT, CURRENT_WEATHER_PARAMS)
            parameter(PARAM_HOURLY, HOURLY_WEATHER_PARAMS)
            parameter(PARAM_DAILY, DAILY_WEATHER_PARAMS)
            parameter(PARAM_START_HOUR, timeRange.startHour)
            parameter(PARAM_END_HOUR, timeRange.endHour)
            parameter(PARAM_START_DATE, timeRange.startDate)
            parameter(PARAM_END_DATE, timeRange.endDate)
            parameter(PARAM_TIMEZONE, PARAM_TIMEZONE_VALUE)
        }.body()
    }
}
