package com.jama.wit_sw_android_challenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import androidx.transition.TransitionInflater
import com.jama.wit_sw_android_challenge.helpers.LeafletWebViewClient
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.databinding.FragmentWeatherBinding
import com.jama.wit_sw_android_challenge.helpers.*
import com.jama.wit_sw_android_challenge.models.CityPresentation
import com.jama.wit_sw_android_challenge.models.CoordinatePresentation

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWeatherBinding.inflate(inflater, container, false)

        initialize()

        return binding.root
    }

    private fun initialize() {
        setUpSharedAnimation()
        setUpViews()
    }

    private fun setUpViews() {
        val cityWeather =
            requireArguments().getSerializable(Constants.CITY_WEATHER) as CityPresentation
        binding.apply {
            val city = "${cityWeather.name}, ${cityWeather.sys.countryCode}"
            textViewCity.text = city
            val dateTime = getDateTime(cityWeather.timestamp)
            textViewDateTime.text = dateTime

            val temp = cityWeather.main.temp.toCelcius().toString()
            textViewTemperature.apply {
                text = temp
                transitionName = cityWeather.name
            }
            val tempFeelLike =
                "${getString(R.string.temp_2)} ${cityWeather.main.feelsLike.toCelcius()}" +
                        getString(R.string.degree_celcius)
            textViewTemperatureFeel.text = tempFeelLike
            val description = cityWeather.weather[0].description.toSentenceCase()
            textViewWeatherDescription.text = description
            val weather = cityWeather.weather[0].weather
            val weatherIcon = getWeatherIcon(weather)
            imageViewWeather.setImageResource(weatherIcon)

            val pressure =
                "${getString(R.string.pressure_of)} ${cityWeather.main.pressure} " +
                        getString(R.string.mbar)
            textViewPressure.text = pressure
            val visibility =
                "${getString(R.string.visibility_of)} ${cityWeather.visibility.toKm()}" +
                        getString(R.string.km)
            textViewVisibility.text = visibility

            val windSpeed = "${cityWeather.wind.speed} ${getString(R.string.ms)}"
            textViewWindSpeed.text = windSpeed
            val humidity = "${cityWeather.main.humidity}%"
            textViewHumidity.text = humidity
            val tempMin = cityWeather.main.tempMin.toCelcius()
            val tempMax = cityWeather.main.tempMax.toCelcius()
            val tempMinMax = "$tempMin - $tempMax ${getString(R.string.degree_celcius)}"
            textViewTemperatureMinMax.text = tempMinMax

            val sunriseDateTime = getTime(cityWeather.sys.sunrise)
            textViewSunrise.text = sunriseDateTime
            val sunsetDateTime = getTime(cityWeather.sys.sunset)
            textViewSunset.text = sunsetDateTime

            setUpLeafletMap(webViewMap, cityWeather.coordinate)
        }
    }

    private fun setUpLeafletMap(webView: WebView, coordinate: CoordinatePresentation) {
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(Constants.LEAFLET_FILE_LOCATION)
        webView.webViewClient = LeafletWebViewClient(
            webView,
            coordinate.lat.toString(),
            coordinate.lng.toString()
        )
    }

    private fun setUpSharedAnimation() {
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move).apply {
                duration = Constants.SHARED_ANIM_DELAY
            }

        sharedElementReturnTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move).apply {
                duration = Constants.SHARED_ANIM_DELAY
            }
    }

}