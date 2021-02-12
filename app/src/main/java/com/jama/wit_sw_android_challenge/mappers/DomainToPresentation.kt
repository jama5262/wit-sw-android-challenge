package com.jama.wit_sw_android_challenge.mappers

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
        this.main.toPresentation(),
        this.weather.map { it.toPresentation() },
        this.wind.toPresentation(),
        this.visibility
    )
}

private fun Main.toPresentation(): MainPresentation {
    return MainPresentation(this.temp, this.feelsLike, this.pressure, this.humidity)
}

private fun Wind.toPresentation(): WindPresentation {
    return WindPresentation(this.speed)
}

private fun Weather.toPresentation(): WeatherPresentation {
    return WeatherPresentation(this.main, this.description)
}