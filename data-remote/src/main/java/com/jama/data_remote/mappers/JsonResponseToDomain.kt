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
        this.mainResponse.toDomain(),
        this.weatherResponse.map { it.toDomain() },
        this.windResponse.toDomain(),
        this.visibility
    )
}

private fun MainResponse.toDomain(): Main {
    return Main(this.temp, this.feelsLike, this.pressure, this.humidity)
}

private fun WindResponse.toDomain(): Wind {
    return Wind(this.speed)
}

private fun WeatherResponse.toDomain(): Weather {
    return Weather(this.main, this.description)
}