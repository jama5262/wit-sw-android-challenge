package com.jama.wit_sw_android_challenge.di

import com.jama.data_remote.repositories.ImplWeatherRepository
import com.jama.domain.repositories.WeatherRepository
import com.jama.wit_sw_android_challenge.BuildConfig
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<WeatherRepository> { ImplWeatherRepository(
        openWeatherService = get(),
        appId = BuildConfig.OPEN_WEATHER_API_KEY
    ) }
}