package com.jama.domain.models

data class Main(
    val temp: Double,
    val tempMin: Double,
    val tempMax: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int
)
