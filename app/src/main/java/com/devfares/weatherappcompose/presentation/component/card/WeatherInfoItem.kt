package com.devfares.weatherappcompose.presentation.component.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.presentation.theme.AppColors
import com.devfares.weatherappcompose.presentation.theme.MainFont

@Composable
fun WeatherInfoItem(
    icon: Int,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = AppColors.mainColor,
        shape = RoundedCornerShape(24.dp),
        border = BorderStroke(1.dp, AppColors.borderColor),
        modifier = modifier
    ) {
        Column(
            Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(icon),
                contentDescription = null,
                tint = AppColors.iconColor
            )

            Text(
                text = description,
                color = AppColors.headersColor,
                fontSize = 20.sp,
                fontFamily = MainFont,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                letterSpacing = 0.25.sp,
                modifier = Modifier.padding(top = 8.dp)
            )

            Text(
                text = title,
                color = AppColors.bodyColor,
                fontSize = 14.sp,
                fontFamily = MainFont,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                letterSpacing = 0.25.sp,
                modifier = Modifier.padding(top = 2.dp)
            )
        }
    }

}

@Preview
@Composable
fun WeatherInfoItemPreview() {
    WeatherInfoItem(
        icon = R.drawable.ic_rain,
        title = "Rain",
        description ="13 KM/h",
    )
}