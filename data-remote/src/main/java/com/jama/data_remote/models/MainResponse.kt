package com.jama.data_remote.models

import com.squareup.moshi.Json

data class MainResponse(
    val temp: Double,
    @field: Json(name = "feels_like") val tempMin: Double,
    @field: Json(name = "temp_max") val tempMax: Double,
    @field: Json(name = "temp_min") val feelsLike: Double,
    val pressure: Int,
    val humidity: Int
)
