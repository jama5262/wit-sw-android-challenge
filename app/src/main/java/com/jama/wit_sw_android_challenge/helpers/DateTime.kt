package com.jama.wit_sw_android_challenge.helpers

import android.text.format.DateFormat
import java.util.*

private fun getCalendar(): Calendar {
    return Calendar.getInstance()
}

fun getDateTime(timestamp: Long): String {
    val calendar = getCalendar()
    calendar.timeInMillis = timestamp * 1000
    return DateFormat.format("EEE, MMM d, yyyy h:mm a", calendar).toString()
}

fun getTime(timestamp: Long): String {
    val calendar = getCalendar()
    calendar.timeInMillis = timestamp * 1000
    return DateFormat.format("h:mm a", calendar).toString()
}