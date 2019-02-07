package com.example.weatherforecast.ui.data.db.unitlocalized

interface UnitSpecificCurrentWeather
{
    val cloud: Int
    val conditionIcon : String
    val conditionText : String
    val feelsLike : Double
    val humidity : Int
    val isDay : Int
    val preciption : Double
    val pressure : Double
    val temperature : Double
    val uv : Int
    val visibility : Double
    val windDegree : Double
    val windDirection : Double
    val windSpeed : Double
}