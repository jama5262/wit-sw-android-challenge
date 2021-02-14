package com.jama.wit_sw_android_challenge.ui

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.doOnNextLayout
import androidx.core.view.doOnPreDraw
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.RecyclerView
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.adapters.createCitiesAdapter
import com.jama.wit_sw_android_challenge.databinding.FragmentCitiesBinding
import com.jama.wit_sw_android_challenge.helpers.Constants
import com.jama.wit_sw_android_challenge.helpers.ItemSpacing
import com.jama.wit_sw_android_challenge.helpers.Tutorial
import com.jama.wit_sw_android_challenge.helpers.navigateToFragment
import com.jama.wit_sw_android_challenge.models.CityPresentation
import com.jama.wit_sw_android_challenge.viewModels.CitiesViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CitiesFragment : Fragment(), CitiesInterface {

    private val citiesViewModel: CitiesViewModel by viewModel()

    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewManager: RecyclerView.LayoutManager
    private val cityWeatherAdapter = createCitiesAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
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
        setUpSwipeToRefresh()
        setUpObservers()
    }

    private fun setUpObservers() {
        citiesViewModel.weatherResult.observe(viewLifecycleOwner) {
            cityWeatherAdapter.submitList(it)
        }

        citiesViewModel.showLoading.observe(viewLifecycleOwner) {
            showLoading(it)
        }

        citiesViewModel.showTutorial.observe(viewLifecycleOwner) {
            if (it) {
                lifecycleScope.launch {
                    showTutorial()
                }
            }
        }
    }

    private fun setUpRecyclerView() {
        binding.citiesRecyclerView.apply {
            viewManager = GridLayoutManager(
                requireContext(),
                2,
                LinearLayoutManager.VERTICAL,
                false
            )
            layoutManager = viewManager
            adapter = cityWeatherAdapter
            addItemDecoration(ItemSpacing())
            doOnNextLayout {
                citiesViewModel.checkIfShowTutorial()
            }
        }
    }

    private fun setUpSwipeToRefresh() {
        binding.swipeRefresh.setOnRefreshListener {
            citiesViewModel.getWeather()
        }
    }

    private fun showLoading(show: Boolean) {
        binding.apply {
            swipeRefresh.isRefreshing = show
            includeLoading.root.visibility = if (show) View.VISIBLE else View.GONE
            citiesRecyclerView.visibility = if (!show) View.VISIBLE else View.GONE
        }
    }

    private fun scrollRecyclerViewToTop() {
        val smoothScroller = object : LinearSmoothScroller(requireContext()) {
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }
        smoothScroller.targetPosition = 0
        viewManager.startSmoothScroll(smoothScroller)
    }

    private suspend fun showTutorial() {
        scrollRecyclerViewToTop()
        delay(Constants.TOUR_DELAY)
        val tutorial = Tutorial(requireActivity())
        tutorial.apply {
            add(
                getString(R.string.tutorial_desc_1)
            )
            add(
                getString(R.string.tutorial_desc_2),
                viewManager.findViewByPosition(2)!!
            )
            add(
                getString(R.string.tutorial_desc_3),
            )
            add(
                getString(R.string.tutorial_desc_4),
                requireActivity().findViewById(R.id.show_tour)
            )
            show()
        }
        citiesViewModel.showTutorial(false)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.city_weather_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.show_tour -> {
                citiesViewModel.showTutorial(true)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}