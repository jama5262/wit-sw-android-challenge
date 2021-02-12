package com.jama.wit_sw_android_challenge.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jama.domain.usecases.GetWeatherUseCase
import com.jama.wit_sw_android_challenge.mappers.toPresentation
import com.jama.wit_sw_android_challenge.models.WeatherResultPresentation
import kotlinx.coroutines.launch

class CitiesViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
): ViewModel() {

    private val _weatherResult = MutableLiveData<WeatherResultPresentation>()
    val weatherResult = _weatherResult

    init {
        getWeather()
    }

    private fun getWeather() {
        viewModelScope.launch {
            _weatherResult.value = getWeatherUseCase.invoke().toPresentation()
        }
    }
}