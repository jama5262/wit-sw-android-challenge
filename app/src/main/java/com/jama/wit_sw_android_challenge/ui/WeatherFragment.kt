package com.jama.wit_sw_android_challenge.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jama.wit_sw_android_challenge.R
import com.jama.wit_sw_android_challenge.databinding.FragmentWeatherBinding
import com.jama.wit_sw_android_challenge.helpers.*
import com.jama.wit_sw_android_challenge.models.CityPresentation

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
        val cityWeather = requireArguments().getSerializable("cityWeather") as CityPresentation
        setUpViews(cityWeather)
    }

    private fun setUpViews(cityWeather: CityPresentation) {
        binding.apply {
            val city = cityWeather.name
            textViewCity.text = city
            val dateTime = getDateTime(cityWeather.timestamp)
            textViewDateTime.text = dateTime

            val temp = cityWeather.main.temp.toCelcius().toString()
            textViewTemperature.text = temp
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
            val visibility = "${getString(R.string.visibility_of)} ${cityWeather.visibility.toKm()}" +
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
        }
    }


}