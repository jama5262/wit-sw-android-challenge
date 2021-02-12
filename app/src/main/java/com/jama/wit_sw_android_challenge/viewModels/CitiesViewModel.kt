package com.jama.wit_sw_android_challenge.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jama.domain.models.WeatherResult
import com.jama.domain.usecases.GetWeatherUseCase
import kotlinx.coroutines.launch

class CitiesViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

    private val _weatherResult = MutableLiveData<WeatherResult>()
    val weatherResult = _weatherResult

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            _weatherResult.value = getWeatherUseCase.invoke()
        }
    }
}