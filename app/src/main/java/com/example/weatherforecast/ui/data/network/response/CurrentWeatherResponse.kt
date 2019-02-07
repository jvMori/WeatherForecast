package com.example.weatherforecast.ui.data.network.response

import com.example.weatherforecast.ui.data.db.entity.CurrentWeather
import com.example.weatherforecast.ui.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeather: CurrentWeather,
    val location: Location
)