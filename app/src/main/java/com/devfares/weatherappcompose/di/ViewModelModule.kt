package com.devfares.weatherappcompose.di

import com.devfares.weatherappcompose.presentation.screen.weatherScreen.WeatherViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule =
    module {
        viewModel { WeatherViewModel(get()) }
    }