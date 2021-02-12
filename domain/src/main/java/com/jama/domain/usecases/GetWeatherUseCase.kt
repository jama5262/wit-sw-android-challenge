package com.jama.domain.usecases

import com.jama.domain.models.WeatherResult
import com.jama.domain.repositories.WeatherRepository

class GetWeatherUseCase (
    private val weatherRepository: WeatherRepository
): BaseUseCase<String, WeatherResult> {

    override suspend fun invoke(param: String): WeatherResult {
        return weatherRepository.getWeather(param)
    }

}