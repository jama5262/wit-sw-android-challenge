package com.jama.wit_sw_android_challenge.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.adapters.createCitiesAdapter
import com.jama.wit_sw_android_challenge.databinding.CityItemBinding
import com.jama.wit_sw_android_challenge.databinding.FragmentCitiesBinding
import com.jama.wit_sw_android_challenge.helpers.ItemSpacing
import com.jama.wit_sw_android_challenge.viewModels.CitiesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CitiesFragment : Fragment() {

    private val citiesViewModel: CitiesViewModel by viewModel()

    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    private val cityWeatherAdapter = createCitiesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCitiesBinding.inflate(inflater, container, false)

        initialize()

        return binding.root
    }

    private fun initialize() {
        setUpRecyclerView()
        setUpObservers()
    }

    private fun setUpObservers() {
        citiesViewModel.weatherResult.observe(viewLifecycleOwner) {
            Log.e("jjj", "$it")
            cityWeatherAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        binding.citiesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = cityWeatherAdapter
            addItemDecoration(ItemSpacing())
        }
    }
}