package com.devfares.weatherappcompose.domain.repository

import com.devfares.weatherappcompose.domain.entity.UserLocation

interface LocationRepository {
    suspend fun getCurrentLocation(): UserLocation
}