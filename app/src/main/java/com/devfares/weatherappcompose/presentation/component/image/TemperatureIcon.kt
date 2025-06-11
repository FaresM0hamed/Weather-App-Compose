package com.devfares.weatherappcompose.presentation.component.image

import BlurredCircle
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.devfares.weatherappcompose.domain.entity.enums.WeatherCondition
import com.devfares.weatherappcompose.presentation.mapper.toDrawableRes
import com.devfares.weatherappcompose.presentation.theme.AppColors
import com.devfares.weatherappcompose.presentation.theme.WeatherAppComposeTheme

@Composable
fun TemperatureIcon(
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    weatherCondition: WeatherCondition,
    isDay: Boolean = true
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        BlurredCircle(
            size = size* 1.15f,
            color = AppColors.blurColor
        )
        Image(
            painter = painterResource(weatherCondition.toDrawableRes(isDay = isDay)),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.height(size)
        )
    }
}

@Preview(showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_UNDEFINED
)
@Composable
private fun CurrentTemperatureIconPreview() {
    WeatherAppComposeTheme {
        Box(modifier = Modifier.size(200.dp),
            contentAlignment = Alignment.Center
        ) {
            TemperatureIcon(
                weatherCondition = WeatherCondition.CLEAR
            )
        }
    }
}