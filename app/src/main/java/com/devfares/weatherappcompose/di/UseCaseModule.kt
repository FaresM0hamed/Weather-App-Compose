package com.devfares.weatherappcompose.di

import com.devfares.weatherappcompose.domain.useCase.GetWeatherUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val useCaseModule = module {
    singleOf(::GetWeatherUseCase)
}