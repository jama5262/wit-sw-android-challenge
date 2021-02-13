package com.jama.wit_sw_android_challenge.models

import java.io.Serializable

data class MainPresentation(
    val temp: Double,
    val tempMin: Double,
    val tempMax: Double,
    val feelsLike: Double,
    val pressure: Int,
    val humidity: Int
): Serializable
