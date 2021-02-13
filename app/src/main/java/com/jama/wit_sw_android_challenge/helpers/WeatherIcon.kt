package com.jama.wit_sw_android_challenge.helpers

import com.jama.wit_sw_android_challenge.R

fun getWeatherIcon(weather: String): Int {
    return when(weather) {
        "Clear" -> R.drawable.ic_sun_solid
        "Thunderstorm" -> R.drawable.ic_bolt_solid
        "Drizzle" -> R.drawable.ic_cloud_rain_solid
        "Rain" -> R.drawable.ic_cloud_showers_heavy_solid
        "Snow" -> R.drawable.ic_snowflake_regular
        "Mist" -> R.drawable.ic_smog_solid
        "Clouds" -> R.drawable.ic_cloud_solid
        else -> R.drawable.ic_sun_solid
    }
}