package com.devfares.weatherappcompose.presentation.component.text

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devfares.weatherappcompose.ui.theme.AppColors
import com.devfares.weatherappcompose.ui.theme.MainFont

@Composable
fun CurrentWeather(
    temperature: String,
    condition: String,
    maxTemperature: String,
    minTemperature: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = temperature,
            color = AppColors.titleColor,
            fontSize = 64.sp,
            fontFamily = MainFont,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            letterSpacing = 0.25.sp,
        )

        Text(
            text = condition,
            color = AppColors.bodyColor,
            fontSize = 16.sp,
            fontFamily = MainFont,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            letterSpacing = 0.25.sp,
        )

        MinAndMaxTemperature(
            modifier = modifier
                .background(
                    AppColors.borderColor,
                    shape = RoundedCornerShape(180.dp)
                )
                .padding(horizontal = 24.dp, vertical = 8.dp),
            dividerColor = AppColors.dividerColor,
            textAndIconsColor = AppColors.headersColor,
            minTemperature = minTemperature,
            maxTemperature = maxTemperature,
        )
    }
}

@Preview
@Composable
private fun CurrentWeatherPreview() {
    CurrentWeather(
        temperature = "25°C",
        condition = "Sunny",
        maxTemperature = "30°C",
        minTemperature = "20°C",
    )
}