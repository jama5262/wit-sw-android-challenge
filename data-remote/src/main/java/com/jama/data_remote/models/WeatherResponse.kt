package com.jama.data_remote.models

import com.squareup.moshi.Json

data class WeatherResponse(
    @field: Json(name = "main") val weather: String,
    val description: String
)