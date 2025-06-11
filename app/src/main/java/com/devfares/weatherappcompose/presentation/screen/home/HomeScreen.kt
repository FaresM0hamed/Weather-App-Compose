package com.devfares.weatherappcompose.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.presentation.component.card.HourlyWeatherItem
import com.devfares.weatherappcompose.presentation.component.card.Next7DaysItem
import com.devfares.weatherappcompose.presentation.component.card.WeatherInfoItem
import com.devfares.weatherappcompose.presentation.component.image.HeaderWeatherIcon
import com.devfares.weatherappcompose.presentation.component.text.CityName
import com.devfares.weatherappcompose.presentation.component.text.CurrentWeather
import com.devfares.weatherappcompose.presentation.component.text.MainTitle
import com.devfares.weatherappcompose.presentation.mapper.toDrawableRes
import com.devfares.weatherappcompose.presentation.mapper.toLocalizedStringRes
import com.devfares.weatherappcompose.ui.theme.AppColors

@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel = viewModel()) {
    val uiState = viewModel.uiState.collectAsState().value
    when {
        uiState.isLoading -> {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator()
            }
        }

        uiState.errorMessage != null -> {
            Column(
                modifier = modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = uiState.errorMessage,
                    color = AppColors.arrowsColor,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }

        else -> {
            HomeContent(
                uiState = uiState,
                modifier = modifier
            )
        }
    }
}


@Composable
fun HomeContent(
    uiState: HomeUiState,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(AppColors.startGradient, AppColors.endGradient)
                )
            )
            .padding(horizontal = 12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        CityName(name = uiState.weather.cityName, Modifier.padding(top = 26.dp))

        HeaderWeatherIcon(
            uiState.weather.toDrawableRes(uiState.weather.isDay),
            Modifier.padding(top = 12.dp)
        )

        CurrentWeather(
            minTemperature = uiState.weather.minimumTemperature.toString(),
            maxTemperature = uiState.weather.maximumTemperature.toString(),
            temperature = uiState.weather.currentTemperature.toString(),
            condition = uiState.weather.condition.toLocalizedStringRes().toString(),
            modifier = Modifier.padding(top = 12.dp)
        )
        BasicCurrentWeatherInformation(modifier)
        MainTitle(
            title = "Today", modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.Start)
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 12.dp)
        ) {
            items(listOf(1, 2, 3, 4, 5)) { item ->
                HourlyWeatherItem()
            }
        }
        MainTitle(
            title = "Next 7 days", modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.Start)
        )
        Surface(
            color = AppColors.mainColor,
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, AppColors.borderColor),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
        ) {
            Column(
                modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp),

                ) {
                Next7DaysItem(
                    minTemperature = 5.toString(),
                    maxTemperature = 6.toString(),
                )
            }
        }
    }
}

@Composable
private fun BasicCurrentWeatherInformation(modifier: Modifier) {
    Column(
        Modifier.padding(top = 24.dp), verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            WeatherInfoItem(icon = R.drawable.ic_fast_wind, title = "Wind", Modifier.weight(1f))
            WeatherInfoItem(icon = R.drawable.ic_humidity, title = "Humidity", Modifier.weight(1f))
            WeatherInfoItem(icon = R.drawable.ic_rain, title = "Rain", Modifier.weight(1f))
        }
        Row(
            modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            WeatherInfoItem(icon = R.drawable.ic_uv_index, title = "UV Index", Modifier.weight(1f))
            WeatherInfoItem(icon = R.drawable.ic_pressure, title = "Pressure", Modifier.weight(1f))
            WeatherInfoItem(
                icon = R.drawable.ic_temperature, title = "Feels Like", Modifier.weight(1f)
            )
        }

    }
}

@Preview(showBackground = true, device = "spec:width=411dp,height=891dp")
@Composable
private fun WeatherHomeScreenPreview() {
    HomeContent(
        uiState = HomeUiState(
            isLoading = false,
            errorMessage = null,
        ),
        modifier = Modifier.fillMaxSize()
    )
}