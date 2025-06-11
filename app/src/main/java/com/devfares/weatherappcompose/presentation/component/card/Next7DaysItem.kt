package com.devfares.weatherappcompose.presentation.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.presentation.component.text.MinAndMaxTemperature
import com.devfares.weatherappcompose.ui.theme.AppColors
import com.devfares.weatherappcompose.ui.theme.MainFont

@Composable
fun Next7DaysItem(
    minTemperature: String,
    maxTemperature: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = "Monday",
            color = AppColors.bodyColor,
            fontSize = 16.sp,
            fontFamily = MainFont,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            letterSpacing = 0.25.sp,
            modifier = Modifier
                .weight(1f)
                .padding(end = 10.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.light_clear_sky),
            contentDescription = null,
            modifier = Modifier
                .height(32.dp)
                .weight(1f)
                .padding(end = 10.dp)
        )

        MinAndMaxTemperature(
            spaceBetweenDivider = 4,
            textAndIconsColor = AppColors.headersColor,
            dividerColor = AppColors.dividerColor,
            minTemperature = minTemperature,
            maxTemperature = maxTemperature,

            )
    }
}

@Preview
@Composable
fun Next7DaysItemPreview() {
    Next7DaysItem(
        minTemperature = "15°",
        maxTemperature = "25°",
    )
}