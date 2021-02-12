package com.jama.wit_sw_android_challenge.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.viewModels.CitiesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CitiesFragment : Fragment() {

    private lateinit var rootView: View

    private val citiesViewModel: CitiesViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        rootView = inflater.inflate(R.layout.fragment_cities, container, false)

        setUpObservers()

        return rootView
    }

    private fun setUpObservers() {
        citiesViewModel.weatherResult.observe(viewLifecycleOwner) {
            Log.e("jjj", "$it")
        }
    }
}