package com.example.weatherforecast.ui.data.db.unitlocalized

import androidx.room.ColumnInfo

data class ImperialCurrentWeather
(
    override val cloud: Int,
    @ColumnInfo(name = "condition_icon")
    override val conditionIcon: String,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "feelslikeF")
    override val feelsLike: Double,
    override val humidity: Int,
    override val isDay: Int,
    @ColumnInfo(name="precipIn")
    override val preciption: Double,
    @ColumnInfo(name="pressureIn")
    override val pressure: Double,
    @ColumnInfo(name="tempF")
    override val temperature: Double,
    override val uv: Int,
    @ColumnInfo(name="visMiles")
    override val visibility: Double,
    override val windDegree: Double,
    override val windDirection: Double,
    @ColumnInfo(name="windMph")
    override val windSpeed: Double
) : UnitSpecificCurrentWeather