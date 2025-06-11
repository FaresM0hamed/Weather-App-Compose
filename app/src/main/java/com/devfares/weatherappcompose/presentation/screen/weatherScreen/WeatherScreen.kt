package com.devfares.weatherappcompose.presentation.screen.weatherScreen

import android.Manifest
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.presentation.component.card.HourlyWeatherItem
import com.devfares.weatherappcompose.presentation.component.card.Next7DaysItem
import com.devfares.weatherappcompose.presentation.component.card.WeatherInfoItem
import com.devfares.weatherappcompose.presentation.component.image.TemperatureIcon
import com.devfares.weatherappcompose.presentation.component.text.CityName
import com.devfares.weatherappcompose.presentation.component.text.CurrentWeather
import com.devfares.weatherappcompose.presentation.component.text.MainTitle
import com.devfares.weatherappcompose.presentation.mapper.toLocalizedStringRes
import com.devfares.weatherappcompose.presentation.theme.AppColors
import com.devfares.weatherappcompose.presentation.theme.WeatherAppComposeTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import org.koin.androidx.compose.koinViewModel
import kotlin.math.min

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherApp(weatherViewModel: WeatherViewModel) {
    val locationPermissionState = rememberPermissionState(Manifest.permission.ACCESS_FINE_LOCATION)

    LaunchedEffect(Unit) {
        locationPermissionState.launchPermissionRequest()
    }

    LaunchedEffect(locationPermissionState.status.isGranted) {
        if (locationPermissionState.status.isGranted) {
            weatherViewModel.fetchWeather()
        }
    }

    WeatherAppComposeTheme(isDay = weatherViewModel.uiState.collectAsState().value.isDay) {
        if (locationPermissionState.status.isGranted) {
            WeatherScreen(viewModel = weatherViewModel)
        }
    }
}

@Composable
fun WeatherScreen(
    modifier: Modifier = Modifier,
    viewModel: WeatherViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState().value

    when {
        uiState.isLoading -> LoadingState(modifier)
        uiState.errorMessage != null -> ErrorState(modifier, uiState.errorMessage)
        else -> WeatherContent(uiState = uiState, modifier = modifier)
    }
}

@Composable
private fun LoadingState(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
private fun ErrorState(modifier: Modifier, errorMessage: String) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = errorMessage,
            color = AppColors.arrowsColor,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun WeatherContent(uiState: WeatherUiState, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    val density = LocalDensity.current

    val scrollProgress = min(scrollState.value / 400f, 1f)

    val animatedScrollProgress by animateFloatAsState(
        targetValue = scrollProgress,
        label = "ScrollProgressAnimation"
    )

    val headerIconScale = 1f - (animatedScrollProgress * 0.4f)
    val headerIconOffsetX = -(animatedScrollProgress * 120f)
    val headerIconOffsetY = animatedScrollProgress * 130f

    val currentWeatherOffsetX = animatedScrollProgress * 100f
    val currentWeatherOffsetY = -(animatedScrollProgress * 80f)
    val contentOffsetY = -(animatedScrollProgress * 80f)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        AppColors.startGradient,
                        AppColors.endGradient
                    )
                )
            )
            .windowInsetsPadding(WindowInsets.systemBars)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            CityName(name = uiState.cityName, Modifier.padding(top = 26.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .offset(y = (-5).dp)
            ) {
                TemperatureIcon(
                    weatherCondition = uiState.condition,
                    isDay = uiState.isDay,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .graphicsLayer {
                            scaleX = headerIconScale
                            scaleY = headerIconScale
                            translationX = with(density) { headerIconOffsetX.dp.toPx() }
                            translationY = with(density) { headerIconOffsetY.dp.toPx() }
                        }
                )

            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp)
                    .graphicsLayer {
                        translationX = with(density) { currentWeatherOffsetX.dp.toPx() }
                        translationY = with(density) { currentWeatherOffsetY.dp.toPx() }
                    }
            ) {
                CurrentWeather(
                    minTemperature = uiState.minimumTemperature,
                    maxTemperature = uiState.maximumTemperature,
                    temperature = uiState.currentTemperature,
                    condition = stringResource(id = uiState.condition.toLocalizedStringRes()),
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = contentOffsetY.dp)
            ) {
                BasicCurrentWeatherInformation(uiState)
                TodaySection(uiState, modifier = Modifier.align(Alignment.Start))
                Next7DaysSection(uiState, modifier = Modifier.align(Alignment.Start))
            }
        }
    }
}

@Composable
private fun TodaySection(uiState: WeatherUiState, modifier: Modifier) {
    MainTitle(
        title = stringResource(R.string.today),
        modifier = modifier.padding(top = 24.dp, start = 12.dp, end = 12.dp)
    )

    LazyRow(
        modifier = Modifier
            .padding(top = 12.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(uiState.hourlyForecast) { hourlyForecastUiState ->
            HourlyWeatherItem(
                time = hourlyForecastUiState.time,
                temperature = hourlyForecastUiState.temperature,
                weatherCondition = hourlyForecastUiState.weatherCondition,
                isDay = hourlyForecastUiState.isDay
            )
        }
    }
}

@Composable
private fun Next7DaysSection(uiState: WeatherUiState, modifier: Modifier) {
    MainTitle(
        title = stringResource(R.string.next_7_days),
        modifier = modifier.padding(top = 24.dp, start = 12.dp, end = 12.dp)
    )

    Surface(
        color = AppColors.mainColor,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, AppColors.borderColor),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 12.dp)
    ) {
        Column(
            Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            uiState.dailyForecast.forEachIndexed { index, forecast ->
                Next7DaysItem(
                    dayName = forecast.dayName,
                    minTemperature = forecast.minimumTemperature,
                    maxTemperature = forecast.maximumTemperature,
                    weatherCondition = forecast.weatherCondition,
                )
                if (index < uiState.dailyForecast.size - 1) {
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = AppColors.borderColor,
                        modifier = Modifier.scale(1.1f)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun BasicCurrentWeatherInformation(uiState: WeatherUiState) {
    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 12.dp, end = 12.dp),
        maxItemsInEachRow = 3,
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        WeatherInfoItem(
            icon = R.drawable.ic_fast_wind,
            title = stringResource(R.string.wind),
            description = uiState.windSpeed,
            modifier = Modifier.weight(1f)
        )
        WeatherInfoItem(
            icon = R.drawable.ic_humidity,
            title = stringResource(R.string.humidity),
            description = uiState.humidityPercentage,
            modifier = Modifier.weight(1f)
        )
        WeatherInfoItem(
            icon = R.drawable.ic_rain,
            title = stringResource(R.string.rain),
            description = uiState.rainPercentage,
            modifier = Modifier.weight(1f)
        )
        WeatherInfoItem(
            icon = R.drawable.ic_uv_index,
            title = stringResource(R.string.uv_index),
            description = uiState.ultravioletIndex,
            modifier = Modifier.weight(1f)
        )
        WeatherInfoItem(
            icon = R.drawable.ic_pressure,
            title = stringResource(R.string.pressure),
            description = uiState.surfacePressure,
            modifier = Modifier.weight(1f)
        )
        WeatherInfoItem(
            icon = R.drawable.ic_temperature,
            title = stringResource(R.string.feels_like),
            description = uiState.feelsLikeTemperature,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true, device = "id:pixel_9_pro_xl")
@Composable
private fun WeatherHomeScreenPreview() {
    WeatherContent(
        uiState = WeatherUiState(isLoading = false, errorMessage = null),
        modifier = Modifier.fillMaxSize()
    )
}
