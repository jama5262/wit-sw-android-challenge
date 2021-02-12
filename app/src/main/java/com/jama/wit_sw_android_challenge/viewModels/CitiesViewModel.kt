package com.jama.wit_sw_android_challenge.viewModels

import androidx.lifecycle.ViewModel
import com.jama.domain.usecases.GetWeatherUseCase

class CitiesViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

}