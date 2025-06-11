package com.devfares.weatherappcompose.presentation.component.image

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.devfares.weatherappcompose.R

@Composable
fun HeaderWeatherIcon(
    icon: Int,
    modifier: Modifier = Modifier
) {

    Image(
        painter = painterResource(icon),
        contentDescription = "Weather Icon",
        modifier = modifier
    )

}

@Preview
@Composable
private fun HeaderWeatherIconPreview() {
    HeaderWeatherIcon(
        icon = R.drawable.ic_rain
    )
}