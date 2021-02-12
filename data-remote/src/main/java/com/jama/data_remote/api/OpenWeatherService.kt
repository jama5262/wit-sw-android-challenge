package com.jama.data_remote.api

import com.jama.data_remote.models.WeatherResultResponse
import retrofit2.http.GET
import retrofit2.http.Query
import javax.xml.ws.Response

interface OpenWeatherService {

    @GET
    suspend fun getWeather(
        @Query("id") id: String,
        @Query("appid") appId: String
    ): Response<WeatherResultResponse>
}