package com.devfares.weatherappcompose.presentation.component.card

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition
import com.devfares.weatherappcompose.presentation.component.image.TemperatureIcon
import com.devfares.weatherappcompose.presentation.component.text.MinAndMaxTemperature
import com.devfares.weatherappcompose.presentation.theme.AppColors
import com.devfares.weatherappcompose.presentation.theme.MainFont

@Composable
fun Next7DaysItem(
    minTemperature: String,
    maxTemperature: String,
    dayName: String,
    weatherCondition:WeatherCondition,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = dayName,
            color = AppColors.bodyColor,
            fontSize = 16.sp,
            fontFamily = MainFont,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .padding(end = 10.dp)
                .align(Alignment.CenterStart)
        )


        TemperatureIcon(
            size = 32.dp,
            weatherCondition = weatherCondition,
            isDay = true,
            modifier = Modifier
                .align(Alignment.TopCenter)

        )

        MinAndMaxTemperature(
            spaceBetweenDivider = 4,
            textAndIconsColor = AppColors.headersColor,
            dividerColor = AppColors.dividerColor,
            minTemperature = minTemperature,
            maxTemperature = maxTemperature,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@Preview
@Composable
fun Next7DaysItemPreview() {
    Next7DaysItem(
        minTemperature = "15°",
        maxTemperature = "25°",
        dayName = "Monday",
        weatherCondition = WeatherCondition.CLEAR,
    )
}