package com.devfares.weatherappcompose.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.location.Geocoder
import com.devfares.weatherappcompose.domain.entity.Location
import com.devfares.weatherappcompose.domain.repository.LocationRepository
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.tasks.await
import java.util.Locale


@SuppressLint("MissingPermission")
class LocationRepositoryImpl(
    private val context: Context
) : LocationRepository {
    private val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context)

    override suspend fun getCurrentLocation(): Location {
        val location = getLastKnownLocation()
        val cityName = getCityNameFromCoordinates(location.latitude, location.longitude)

        return Location(
            latitude = location.latitude,
            longitude = location.longitude,
            cityName = cityName
        )
    }

    private suspend fun getLastKnownLocation(): android.location.Location {
        return fusedLocationProviderClient.lastLocation.await()
            ?: throw IllegalStateException("No location available")
    }

    private fun getCityNameFromCoordinates(latitude: Double, longitude: Double): String {
        val geocoder = Geocoder(context, Locale.ENGLISH)
        val addresses = geocoder.getFromLocation(latitude, longitude, 1)

        return if (!addresses.isNullOrEmpty()) {
            addresses[0].locality ?: addresses[0].subAdminArea ?: "Unknown city"
        } else "Unknown city"
    }
}


