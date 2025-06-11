package com.devfares.weatherappcompose.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SweepGradient
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80, secondary = PurpleGrey80, tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40, secondary = PurpleGrey40, tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun WeatherAppComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val customColors = if (darkTheme) DarkColors else LightColors
    CompositionLocalProvider(
        LocalAppColors provides customColors,
        LocalThemeInfo provides ThemeInfo(isDay = !darkTheme)
    ) {
        MaterialTheme(
            colorScheme = colorScheme, typography = Typography, content = content
        )
    }
}

val AppColors: AppColorScheme
    @Composable get() = LocalAppColors.current



@Immutable
data class ThemeInfo(
    val isDay: Boolean = true,
)

val LocalAppColors = staticCompositionLocalOf { LightColors }
val LocalThemeInfo = staticCompositionLocalOf { ThemeInfo() }

data class AppColorScheme(
    val mainColor: Color,
    val iconColor: Color,
    val headersColor: Color,
    val bodyColor: Color,
    val borderColor: Color,
    val titleColor: Color,
    val arrowsColor: Color,
    val cityNameColor: Color,
    val startGradient: Color,
    val endGradient: Color,
    val dividerColor: Color
)

private val LightColors = AppColorScheme(
    mainColor = Color(0xB3FFFFFF),
    iconColor = Color(0xFF87CEFA),
    headersColor = Color(0xDE060414),
    bodyColor = Color(0x99060414),
    borderColor = Color(0x14060414),
    titleColor = Color(0xFF060414),
    arrowsColor = Color(0x99060414),
    cityNameColor = Color(0xFF323232),
    startGradient = Color(0xFF87CEFA),
    endGradient = Color(0xFFFFFFFF),
    dividerColor = Color(0x3D060414)
)

private val DarkColors = AppColorScheme(
    mainColor = Color(0xB3060414),
    iconColor = Color(0xFF87CEFA),
    headersColor = Color(0xDEFFFFFF),
    bodyColor = Color(0x99FFFFFF),
    borderColor = Color(0x14FFFFFF),
    titleColor = Color(0xFFFFFFFF),
    arrowsColor = Color(0xDEFFFFFF),
    cityNameColor = Color(0xFFFFFFFF),
    startGradient = Color(0xFF060414),
    endGradient = Color(0xFF0D0C19),
    dividerColor = Color(0x3DFFFFFF)
)
