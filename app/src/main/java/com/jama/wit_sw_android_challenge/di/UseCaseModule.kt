package com.jama.wit_sw_android_challenge.di

import com.jama.domain.usecases.GetWeatherUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetWeatherUseCase(weatherRepository = get()) }
}

