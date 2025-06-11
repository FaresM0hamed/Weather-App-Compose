package com.devfares.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.devfares.weatherappcompose.presentation.screen.weatherScreen.WeatherApp
import com.devfares.weatherappcompose.presentation.screen.weatherScreen.WeatherViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WeatherApp(weatherViewModel = weatherViewModel)
        }
    }
}
