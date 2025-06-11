package com.devfares.weatherappcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.devfares.weatherappcompose.data.repository.LocationRepositoryImpl
import com.devfares.weatherappcompose.domain.entity.UserLocation
import com.devfares.weatherappcompose.domain.repository.WeatherRepository
import com.devfares.weatherappcompose.ui.theme.WeatherAppComposeTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val weatherRepository: WeatherRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val locationRepository=LocationRepositoryImpl(context = applicationContext)


            LaunchedEffect(true) {
                lifecycleScope.launch {
                    Log.e("Ffff", "onCreate: ${weatherRepository.getWeatherByCoordinates(UserLocation(31.455115,30.522053,""))}")
                    Log.e("Ffff", "onCreate: ${locationRepository.getCurrentLocation()}")
                }
            }

            WeatherAppComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WeatherAppComposeTheme {
        Greeting("Android")
    }
}