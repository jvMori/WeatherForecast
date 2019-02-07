package com.example.weatherforecast.ui.weather.current


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.weatherforecast.R
import com.example.weatherforecast.data.network.ApixuWeatherApiCall
import com.example.weatherforecast.data.network.ConnectivityInterceptorImpl
import com.example.weatherforecast.data.network.WeatherNetworkDataSource
import com.example.weatherforecast.data.network.WeatherNetworkDataSourceImpl
import kotlinx.android.synthetic.main.fragment_current_weather.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class CurrentWeatherFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_current_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apixuWeatherApiCall = ApixuWeatherApiCall.invoke(
            ConnectivityInterceptorImpl(
                this.context!!
            )
        )
        val weatherNetworkDataSource =
            WeatherNetworkDataSourceImpl(apixuWeatherApiCall)
        weatherNetworkDataSource.downloadedCurrentWeather.observe(this, Observer {
            textView.text = it.toString()
        })
        GlobalScope.launch(Dispatchers.Main) {
            weatherNetworkDataSource.fetchCurrentWeather("Cracow", "en")
        }
    }
}
