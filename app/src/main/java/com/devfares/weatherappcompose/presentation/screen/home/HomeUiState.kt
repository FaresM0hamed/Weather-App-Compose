package com.devfares.weatherappcompose.presentation.screen.home

import com.devfares.weatherappcompose.domain.entity.Weather
import com.devfares.weatherappcompose.presentation.util.mockWeather

data class HomeUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val weather: Weather = mockWeather(),
)
