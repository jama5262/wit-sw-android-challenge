package com.jama.wit_sw_android_challenge.di

import com.jama.data_remote.api.OpenWeatherService
import com.jama.wit_sw_android_challenge.helpers.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { provideRetrofit() }
    single { provideOpenWeatherService(retrofit = get()) }
}

private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
}

private fun provideOpenWeatherService(retrofit: Retrofit): OpenWeatherService {
    return retrofit.create(OpenWeatherService::class.java)
}