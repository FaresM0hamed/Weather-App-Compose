package com.devfares.weatherappcompose.domain.repository

import com.devfares.weatherappcompose.domain.entity.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location
}