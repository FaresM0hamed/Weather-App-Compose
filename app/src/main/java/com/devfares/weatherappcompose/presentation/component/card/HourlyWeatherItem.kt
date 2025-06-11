package com.devfares.weatherappcompose.presentation.component.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition
import com.devfares.weatherappcompose.presentation.component.image.TemperatureIcon
import com.devfares.weatherappcompose.presentation.mapper.toLocalizedStringRes
import com.devfares.weatherappcompose.presentation.theme.AppColors
import com.devfares.weatherappcompose.presentation.theme.MainFont

@Composable
fun HourlyWeatherItem(
    modifier: Modifier = Modifier,
    time: String,
    temperature: String,
    isDay: Boolean ,
    weatherCondition: WeatherCondition
) {
    Box(
        modifier = modifier

    ) {
        Surface(
            color = AppColors.mainColor,
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, AppColors.borderColor),
            modifier = Modifier
                .padding(top = 12.dp)
                .size(88.dp, 120.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = temperature,
                    color = AppColors.headersColor,
                    fontSize = 16.sp,
                    fontFamily = MainFont,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.padding(top = 46.dp)
                )

                Text(
                    text = time,
                    color = AppColors.bodyColor,
                    fontSize = 16.sp,
                    fontFamily = MainFont,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.25.sp,
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

        }
        TemperatureIcon(
            size = 58.dp,
            weatherCondition = weatherCondition,
            isDay = isDay,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y= (-7).dp)
        )
    }
}

@Preview
@Composable
fun HourlyWeatherItemPreview() {
    HourlyWeatherItem(
        time = "12:00",
        temperature = "25°C",
        isDay = true,
        weatherCondition = WeatherCondition.CLEAR
    )
}