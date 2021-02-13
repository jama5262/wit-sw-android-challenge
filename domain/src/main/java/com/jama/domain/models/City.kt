package com.jama.domain.models

data class City(
    val name: String,
    val timestamp: Long,
    val main: Main,
    val weather: List<Weather>,
    val wind: Wind,
    val visibility: Int,
    val coordinate: Coordinate,
    val sys: Sys
)