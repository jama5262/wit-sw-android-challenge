package com.jama.wit_sw_android_challenge.di

import com.jama.wit_sw_android_challenge.helpers.SharedPref
import com.jama.wit_sw_android_challenge.viewModels.CitiesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    single { SharedPref(get()) }
    viewModel { CitiesViewModel(getWeatherUseCase = get(), sharedPref = get()) }
}