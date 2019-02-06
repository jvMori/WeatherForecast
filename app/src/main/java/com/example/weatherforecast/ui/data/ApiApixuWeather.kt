package com.example.weatherforecast.ui.data

import com.example.weatherforecast.ui.data.response.CurrentWeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

const val apiKey = "7a5ba9d2d18041f38e0135842190602"

//http://api.apixu.com/v1/current.json?key=7a5ba9d2d18041f38e0135842190602&q=London&lang=en

interface ApiApixuWeather
{
    @GET("current.json")
    fun getWeather(
        @Query("q") location: String,
        @Query("lang") lang: String
    ) : Deferred<CurrentWeatherResponse>
}