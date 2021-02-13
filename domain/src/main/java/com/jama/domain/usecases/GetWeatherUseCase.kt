package com.jama.domain.usecases

import com.jama.domain.models.WeatherResult
import com.jama.domain.repositories.WeatherRepository

class GetWeatherUseCase (
    private val weatherRepository: WeatherRepository
): BaseUseCase<WeatherResult> {

    override suspend fun invoke(): WeatherResult {
        return weatherRepository.getWeather()
    }

}