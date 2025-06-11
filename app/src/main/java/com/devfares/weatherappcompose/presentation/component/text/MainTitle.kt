package com.devfares.weatherappcompose.presentation.component.text

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devfares.weatherappcompose.ui.theme.AppColors
import com.devfares.weatherappcompose.ui.theme.MainFont

@Composable
fun MainTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        color = AppColors.titleColor,
        fontSize = 20.sp,
        fontFamily = MainFont,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 0.25.sp,
        modifier = modifier
    )
}