package com.jama.wit_sw_android_challenge.models

import com.jama.domain.models.Coordinate
import com.jama.domain.models.Sys
import java.io.Serializable

data class CityPresentation(
    val name: String,
    val timestamp: Long,
    val main: MainPresentation,
    val weather: List<WeatherPresentation>,
    val wind: WindPresentation,
    val visibility: Int,
    val coordinate: CoordinatePresentation,
    val sys: SysPresentation
): Serializable