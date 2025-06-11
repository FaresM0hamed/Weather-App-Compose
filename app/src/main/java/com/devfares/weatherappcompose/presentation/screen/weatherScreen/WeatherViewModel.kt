package com.devfares.weatherappcompose.presentation.screen.weatherScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devfares.weatherappcompose.domain.useCase.GetWeatherUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

     fun fetchWeather() = viewModelScope.launch {
        updateUiState(isLoading = true)
        runCatching { getWeatherUseCase() }
            .map { it.toUiState().copy(isLoading = false, errorMessage = null) }
            .onSuccess { _uiState.value = it }
            .onFailure { e ->
                updateUiState(isLoading = false, errorMessage = e.message ?: "Unknown error")
            }
    }

    private fun updateUiState(
        isLoading: Boolean? = null,
        errorMessage: String? = null
    ) {
        _uiState.value = _uiState.value.copy(
            isLoading = isLoading ?: _uiState.value.isLoading,
            errorMessage = errorMessage ?: _uiState.value.errorMessage
        )
    }
}