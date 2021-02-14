package com.jama.wit_sw_android_challenge.ui

import android.widget.TextView
import com.jama.wit_sw_android_challenge.models.CityPresentation

interface CitiesInterface {
    fun navigate(cityPresentation: CityPresentation, temp: TextView)
}