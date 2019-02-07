package com.example.weatherforecast.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherforecast.data.network.response.CurrentWeatherResponse
import com.example.weatherforecast.internal.NoConectivityException

class WeatherNetworkDataSourceImpl (
    private val apixuWeatherApiCall: ApixuWeatherApiCall
) : WeatherNetworkDataSource {
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val currentWeather = apixuWeatherApiCall.getWeather(location, languageCode).await()
            _downloadedCurrentWeather.postValue(currentWeather)
        }
        catch(e : NoConectivityException) {
            Log.e("Connectivity", "No internet connection", e)
        }
    }
}