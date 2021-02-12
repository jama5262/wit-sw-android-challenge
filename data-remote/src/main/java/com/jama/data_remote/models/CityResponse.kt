package com.jama.data_remote.models

data class CityResponse(
    val name: String,
    val mainResponse: MainResponse,
    val weatherResponse: List<WeatherResponse>,
    val windResponse: WindResponse,
    val visibility: Int
)