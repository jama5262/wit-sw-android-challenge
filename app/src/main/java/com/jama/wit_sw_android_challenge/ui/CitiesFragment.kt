package com.jama.wit_sw_android_challenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.adapters.createCitiesAdapter
import com.jama.wit_sw_android_challenge.databinding.FragmentCitiesBinding
import com.jama.wit_sw_android_challenge.helpers.Constants
import com.jama.wit_sw_android_challenge.helpers.ItemSpacing
import com.jama.wit_sw_android_challenge.helpers.navigateToFragment
import com.jama.wit_sw_android_challenge.models.CityPresentation
import com.jama.wit_sw_android_challenge.viewModels.CitiesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CitiesFragment : Fragment(), CitiesInterface {

    private val citiesViewModel: CitiesViewModel by viewModel()

    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    private val cityWeatherAdapter = createCitiesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCitiesBinding.inflate(inflater, container, false)

        initialize()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postponeEnterTransition()
        view.doOnPreDraw { startPostponedEnterTransition() }
    }

    private fun initialize() {
        setUpRecyclerView()
        setUpObservers()
    }

    private fun setUpObservers() {
        citiesViewModel.weatherResult.observe(viewLifecycleOwner) {
            cityWeatherAdapter.submitList(it)
        }
    }

    private fun setUpRecyclerView() {
        binding.citiesRecyclerView.apply {
            layoutManager = GridLayoutManager(
                requireContext(),
                2,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = cityWeatherAdapter
            addItemDecoration(ItemSpacing())
        }
    }

    override fun navigate(cityPresentation: CityPresentation, temp: TextView) {
        val bundle = bundleOf(
            Constants.CITY_WEATHER to cityPresentation
        )

        val extras = FragmentNavigatorExtras(
            temp to cityPresentation.name
        )

        findNavController().navigateToFragment(
            R.id.action_citiesFragment_to_weatherFragment,
            bundle,
            extras
        )
    }
}