package com.jama.wit_sw_android_challenge.models

import java.io.Serializable

data class CityPresentation(
    val name: String,
    val mainPresentation: MainPresentation,
    val weatherPresentation: List<WeatherPresentation>,
    val windPresentation: WindPresentation,
    val visibility: Int
): Serializable