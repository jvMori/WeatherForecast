package com.example.weatherforecast.ui.data.db.unitlocalized

import androidx.room.ColumnInfo

data class MetricCurrentWeather (
    override val cloud: Int,
    @ColumnInfo(name = "condition_icon")
    override val conditionIcon: String,
    @ColumnInfo(name = "condition_text")
    override val conditionText: String,
    @ColumnInfo(name = "feelslikeC")
    override val feelsLike: Double,
    override val humidity: Int,
    override val isDay: Int,
    @ColumnInfo(name="precipMm")
    override val preciption: Double,
    @ColumnInfo(name="pressureMb")
    override val pressure: Double,
    @ColumnInfo(name="tempC")
    override val temperature: Double,
    override val uv: Int,
    @ColumnInfo(name="visKm")
    override val visibility: Double,
    override val windDegree: Double,
    @ColumnInfo(name="windDir")
    override val windDirection: Double,
    @ColumnInfo(name="windKph")
    override val windSpeed: Double
) : UnitSpecificCurrentWeather
