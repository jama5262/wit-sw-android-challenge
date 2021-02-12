package com.jama.data_remote.repositories

import com.jama.data_remote.api.OpenWeatherService
import com.jama.data_remote.helpers.Constants
import com.jama.data_remote.mappers.toDomain
import com.jama.domain.models.WeatherResult
import com.jama.domain.repositories.WeatherRepository

class ImplWeatherRepository(
    private val openWeatherService: OpenWeatherService,
    private val appId: String
): WeatherRepository {

    override suspend fun getWeather(): WeatherResult {
        val cityIds = getCityIds()
        return openWeatherService.getWeather(cityIds, appId)
            .body()!!
            .toDomain()
    }

    private fun getCityIds(): String {
        val cities = Constants.CITY_LOCATION_IDS
        return cities.keys.joinToString(separator = ",")
    }
}