package com.jama.wit_sw_android_challenge.helpers

import android.content.Context
import android.content.SharedPreferences
import com.jama.wit_sw_android_challenge.R

class SharedPref(context: Context) {
    private val sharedPreferences = context.getSharedPreferences(
        context.resources.getString(R.string.package_name),
        Context.MODE_PRIVATE
    )

    private fun editSharedPref(action: (s: SharedPreferences.Editor) -> Unit) {
        with(sharedPreferences.edit()) {
            action(this)
            apply()
        }
    }

    fun getShowTutorial(): Boolean {
        return sharedPreferences.getBoolean(Constants.TUTORIAL, true)
    }

    fun setShowTutorial(showTour: Boolean) {
        editSharedPref {
            it.putBoolean(Constants.TUTORIAL, showTour)
        }
    }
}