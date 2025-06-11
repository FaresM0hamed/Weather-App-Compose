package com.devfares.weatherappcompose.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devfares.weatherappcompose.domain.useCase.GetWeatherUseCase
import com.devfares.weatherappcompose.presentation.util.mockWeather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchWeather()
    }

    fun fetchWeather() {
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            val result = runCatching {
                getWeatherUseCase()
            }
            result.onSuccess { weather ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    weather = weather,
                )
            }.onFailure { exception ->
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    weather = mockWeather(),
                    errorMessage = "Failed to load weather: ${exception.message ?: "Unknown error"}"
                )
            }
        }
    }
}