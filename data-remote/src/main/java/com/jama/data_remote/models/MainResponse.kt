package com.jama.data_remote.models

import com.squareup.moshi.Json

data class MainResponse(
    val temp: Double,
    @field: Json(name = "feels_like") val feelsLike: Double,
    val pressure: Int,
    val humidity: Int
)
