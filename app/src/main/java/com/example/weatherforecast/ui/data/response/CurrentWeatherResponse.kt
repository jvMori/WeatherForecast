package com.example.weatherforecast.ui.data.response

import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    val location: Location
)