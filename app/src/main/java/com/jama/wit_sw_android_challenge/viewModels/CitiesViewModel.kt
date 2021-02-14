package com.jama.wit_sw_android_challenge.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jama.domain.usecases.GetWeatherUseCase
import com.jama.wit_sw_android_challenge.mappers.toPresentation
import com.jama.wit_sw_android_challenge.models.CityPresentation
import kotlinx.coroutines.launch

class CitiesViewModel(
    private val getWeatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherResult = MutableLiveData<List<CityPresentation>>()
    val weatherResult = _weatherResult

    private val _showLoading = MutableLiveData<Boolean>(true)
    val showLoading = _showLoading

    init {
        getWeather()
    }

    fun getWeather() {
        viewModelScope.launch {
            _weatherResult.value = getWeatherUseCase.invoke().toPresentation().list
            hideLoading()
        }
    }

    private fun hideLoading() {
        _showLoading.value = false
    }

}