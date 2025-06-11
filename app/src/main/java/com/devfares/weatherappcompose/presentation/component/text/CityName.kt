package com.devfares.weatherappcompose.presentation.component.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devfares.weatherappcompose.R
import com.devfares.weatherappcompose.ui.theme.AppColors
import com.devfares.weatherappcompose.ui.theme.MainFont

@Composable
fun CityName(name: String ,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.location),
            contentDescription = "Location Icon",
            tint = AppColors.cityNameColor,
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text =name,
            color = AppColors.cityNameColor,
            fontSize = 20.sp,
            fontFamily = MainFont,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.25.sp,
            lineHeight = 20.sp,
        )

    }

}

@Preview
@Composable
private fun CityNamePreview() {
    CityName(
        name = "New York",
    )
}