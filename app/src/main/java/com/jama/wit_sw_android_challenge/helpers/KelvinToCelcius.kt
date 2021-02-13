package com.jama.wit_sw_android_challenge.helpers

import kotlin.math.roundToInt

fun Double.toCelcius() = (this - 273.15).roundToInt()