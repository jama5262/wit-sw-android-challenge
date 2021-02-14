package com.jama.data_remote.models

import com.squareup.moshi.Json

data class CoordinateResponse(
    @field: Json(name = "lon") val lng: Double,
    val lat: Double
)
