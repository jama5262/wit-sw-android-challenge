package com.jama.data_remote.repositories

import com.jama.data_remote.api.OpenWeatherService
import com.jama.data_remote.helpers.Constants
import com.jama.domain.models.WeatherResult
import com.jama.domain.repositories.WeatherRepository

class ImplWeatherRepository(
    private val openWeatherService: OpenWeatherService
): WeatherRepository {

    override suspend fun getWeather(appId: String): WeatherResult {
        // TODO: 2/12/2021
    }

    private fun getCityIds(): String {
        val cities = Constants.CITY_LOCATION_IDS
        return cities.keys.joinToString { "," }
    }
}