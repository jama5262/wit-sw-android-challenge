package com.jama.data_remote.models

data class CityResponse(
    val name: String,
    val main: MainResponse,
    val weather: List<WeatherResponse>,
    val wind: WindResponse,
    val visibility: Int
)