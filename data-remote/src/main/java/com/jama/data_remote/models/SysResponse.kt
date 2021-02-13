package com.jama.data_remote.models

import com.squareup.moshi.Json

data class SysResponse(
    @field: Json(name = "country") val countryCode: String,
    val sunrise: Long,
    val sunset: Long
)
