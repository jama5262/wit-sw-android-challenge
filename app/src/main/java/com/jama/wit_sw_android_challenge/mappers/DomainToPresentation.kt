package com.jama.wit_sw_android_challenge.mappers

import com.jama.data_remote.models.CoordinateResponse
import com.jama.data_remote.models.SysResponse
import com.jama.domain.models.*
import com.jama.wit_sw_android_challenge.models.*

fun WeatherResult.toPresentation(): WeatherResultPresentation {
    return WeatherResultPresentation(
        this.list.map { it.toPresentation() }
    )
}

private fun City.toPresentation(): CityPresentation {
    return CityPresentation(
        this.name,
        this.timestamp,
        this.main.toPresentation(),
        this.weather.map { it.toPresentation() },
        this.wind.toPresentation(),
        this.visibility,
        this.coordinate.toPresentation(),
        this.sys.toPresentation()
    )
}

private fun Coordinate.toPresentation(): CoordinatePresentation {
    return CoordinatePresentation(this.lng, this.lat)
}

private fun Sys.toPresentation(): SysPresentation {
    return SysPresentation(this.countryCode, this.sunrise, this.sunset)
}

private fun Main.toPresentation(): MainPresentation {
    return MainPresentation(
        this.temp,
        this.tempMin,
        this.tempMax,
        this.feelsLike,
        this.pressure,
        this.humidity
    )
}

private fun Wind.toPresentation(): WindPresentation {
    return WindPresentation(this.speed)
}

private fun Weather.toPresentation(): WeatherPresentation {
    return WeatherPresentation(this.weather, this.description)
}