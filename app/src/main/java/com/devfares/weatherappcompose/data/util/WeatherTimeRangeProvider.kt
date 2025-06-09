package com.devfares.weatherappcompose.data.util

import com.devfares.weatherappcompose.data.util.Constants.FORECAST_NEXT_7_DAYS
import kotlinx.datetime.*

class WeatherTimeRangeProvider() {
    fun calculateRange(
        timeZone: TimeZone = TimeZone.currentSystemDefault(),
        forecastDays: Int = FORECAST_NEXT_7_DAYS
    ): TimeRange {
        val now = Clock.System.now().toLocalDateTime(timeZone)
        val today = now.date
        val endOfDay = today.atTime(23, 0)

        return TimeRange(
            startHour = "${now.toString().substring(0, 13)}:00",
            endHour = endOfDay.toString(),
            startDate = today.toString(),
            endDate = today.plus(forecastDays, DateTimeUnit.DAY).toString()
        )
    }

    data class TimeRange(
        val startHour: String,
        val endHour: String,
        val startDate: String,
        val endDate: String
    )
}
