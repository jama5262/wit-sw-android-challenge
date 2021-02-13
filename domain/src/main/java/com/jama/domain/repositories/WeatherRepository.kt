package com.jama.domain.repositories

import com.jama.domain.models.WeatherResult

interface WeatherRepository {
    suspend fun getWeather(): WeatherResult
}