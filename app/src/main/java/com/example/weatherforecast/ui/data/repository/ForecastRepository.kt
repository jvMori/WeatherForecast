package com.example.weatherforecast.ui.data.repository

import androidx.lifecycle.LiveData
import com.example.weatherforecast.ui.data.db.unitlocalized.UnitSpecificCurrentWeather

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean) : LiveData<out UnitSpecificCurrentWeather>
}