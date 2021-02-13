package com.jama.wit_sw_android_challenge.helpers

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.FragmentNavigator

fun NavController.navigateToFragment(
    destination: Int,
    bundle: Bundle? = null,
    extras: FragmentNavigator.Extras? = null
) {
    this.navigate(destination, bundle, null, extras)
}