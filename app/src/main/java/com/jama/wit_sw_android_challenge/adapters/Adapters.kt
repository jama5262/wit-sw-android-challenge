package com.jama.wit_sw_android_challenge.adapters

import androidx.recyclerview.widget.ListAdapter
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.models.CityPresentation
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder
import kotlin.math.roundToInt

fun createCitiesAdapter(): ListAdapter<CityPresentation, RecyclerViewHolder<CityPresentation>> {
    return adapterOf {
        register(
            layoutResource = R.layout.city_item,
            viewHolder = ::CityWeatherViewHolder,
            onBindViewHolder = { holder, _, item ->
                holder.binding.apply {
                    val temp = (item.mainPresentation.temp - 273.15).roundToInt()
                    val city = item.name
                    val weather = item.weatherPresentation[0].main
                    val weatherIcon = when (weather) {
                        "Clear" -> R.drawable.ic_sun_solid
                        "Thunderstorm" -> R.drawable.ic_bolt_solid
                        "Drizzle" -> R.drawable.ic_cloud_rain_solid
                        "Rain" -> R.drawable.ic_cloud_showers_heavy_solid
                        "Snow" -> R.drawable.ic_snowflake_regular
                        "Mist" -> R.drawable.ic_smog_solid
                        "Clouds" -> R.drawable.ic_cloud_solid
                        else -> R.drawable.ic_sun_solid
                    }
                    imageViewWeather.setImageResource(weatherIcon)
                    textViewTemperature.text = temp.toString()
                    textViewCity.text = city
                    textViewMain.text = weather
                }
            }
        )
    }
}