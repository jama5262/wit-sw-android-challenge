package com.jama.wit_sw_android_challenge.adapters

import android.view.View
import com.jama.wit_sw_android_challenge.databinding.CityItemBinding
import com.jama.wit_sw_android_challenge.models.CityPresentation
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

class CityWeatherViewHolder(
    view: View
) : RecyclerViewHolder<CityPresentation>(view) {
    val binding = CityItemBinding.bind(view)
}