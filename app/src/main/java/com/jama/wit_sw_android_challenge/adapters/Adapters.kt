package com.jama.wit_sw_android_challenge.adapters

import androidx.recyclerview.widget.ListAdapter
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.helpers.getWeatherIcon
import com.jama.wit_sw_android_challenge.helpers.toCelcius
import com.jama.wit_sw_android_challenge.models.CityPresentation
import com.jama.wit_sw_android_challenge.ui.CitiesInterface
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

fun createCitiesAdapter(citiesInterface: CitiesInterface): ListAdapter<CityPresentation, RecyclerViewHolder<CityPresentation>> {
    return adapterOf {
        register(
            layoutResource = R.layout.city_item,
            viewHolder = ::CityWeatherViewHolder,
            onBindViewHolder = { holder, _, item ->
                holder.binding.apply {
                    val temp = item.main.temp.toCelcius()
                    val city = item.name
                    val weather = item.weather[0].weather
                    val weatherIcon = getWeatherIcon(weather)
                    imageViewWeather.setImageResource(weatherIcon)
                    textViewTemperature.text = temp.toString()
                    textViewCity.text = city
                    textViewMain.text = weather

                    root.setOnClickListener {
                        citiesInterface.navigate(item)
                    }
                }
            }
        )
    }
}