package com.jama.data_remote.models

import com.squareup.moshi.Json

data class CityResponse(
    val name: String,
    @field: Json(name = "dt") val timestamp: Long,
    val main: MainResponse,
    val weather: List<WeatherResponse>,
    val wind: WindResponse,
    val visibility: Int,
    @field: Json(name = "coord") val coordinate: CoordinateResponse,
    val sys: SysResponse
)