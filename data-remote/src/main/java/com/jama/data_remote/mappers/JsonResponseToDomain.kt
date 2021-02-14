package com.jama.data_remote.mappers

import com.jama.data_remote.models.*
import com.jama.domain.models.*

fun WeatherResultResponse.toDomain(): WeatherResult {
    return WeatherResult(
        this.list.map { it.toDomain() }
    )
}

private fun CityResponse.toDomain(): City {
    return City(
        this.name,
        this.timestamp,
        this.main.toDomain(),
        this.weather.map { it.toDomain() },
        this.wind.toDomain(),
        this.visibility,
        this.coordinate.toDomain(),
        this.sys.toDomain()
    )
}

private fun CoordinateResponse.toDomain(): Coordinate {
    return Coordinate(this.lng, this.lat)
}

private fun SysResponse.toDomain(): Sys {
    return Sys(this.countryCode, this.sunrise, this.sunset)
}

private fun MainResponse.toDomain(): Main {
    return Main(this.temp, this.tempMin, this.tempMax, this.feelsLike, this.pressure, this.humidity)
}

private fun WindResponse.toDomain(): Wind {
    return Wind(this.speed)
}

private fun WeatherResponse.toDomain(): Weather {
    return Weather(this.weather, this.description)
}