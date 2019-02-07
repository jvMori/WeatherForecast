package com.example.weatherforecast.ui.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherforecast.ui.data.db.entity.CURRENT_ID
import com.example.weatherforecast.ui.data.db.entity.CurrentWeather
import com.example.weatherforecast.ui.data.db.unitlocalized.ImperialCurrentWeather
import com.example.weatherforecast.ui.data.db.unitlocalized.MetricCurrentWeather

@Dao
interface CurrentWeatherDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (weatherEntry : CurrentWeather)

    @Query("select * from  current_weather where id = $CURRENT_ID " )
    fun getWeatherMetric() : LiveData<MetricCurrentWeather>

    @Query("select * from current_weather where id = $CURRENT_ID")
    fun getWeatherImperial() : LiveData<ImperialCurrentWeather>
}