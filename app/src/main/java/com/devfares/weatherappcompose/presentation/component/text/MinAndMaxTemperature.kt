package com.devfares.weatherappcompose.presentation.component.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
fun MinAndMaxTemperature(
    minTemperature: String,
    maxTemperature: String,
    textAndIconsColor: Color,
    dividerColor: Color,
    modifier: Modifier = Modifier,
    spaceBetweenDivider: Int = 8
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_arrow_up),
            contentDescription = "High",
            tint = textAndIconsColor,
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text = maxTemperature,
            color = textAndIconsColor,
            fontSize = 16.sp,
            fontFamily = MainFont,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(end = spaceBetweenDivider.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.line1),
            contentDescription = "Low",
            tint = dividerColor,
            modifier = Modifier.padding(end = spaceBetweenDivider.dp)
        )
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.arrow_down),
            contentDescription = "Down",
            tint = textAndIconsColor,
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text = minTemperature,
            color = textAndIconsColor,
            fontSize = 16.sp,
            fontFamily = MainFont,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            letterSpacing = 0.25.sp,
        )
    }
}


@Preview
@Composable
fun MinAndMaxTemperaturePreview() {
    MinAndMaxTemperature(
        textAndIconsColor = AppColors.headersColor,
        dividerColor = AppColors.borderColor,
        minTemperature = "10°C",
        maxTemperature = "20°C",
    )
}