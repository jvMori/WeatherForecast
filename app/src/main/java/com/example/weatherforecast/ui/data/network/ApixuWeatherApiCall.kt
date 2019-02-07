package com.example.weatherforecast.ui.data.network

import com.example.weatherforecast.ui.data.network.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val apiKey = "7a5ba9d2d18041f38e0135842190602"
const val BASE_URL = "https://api.apixu.com/v1/"

//http://api.apixu.com/v1/current.json?key=7a5ba9d2d18041f38e0135842190602&q=London&lang=en

interface ApixuWeatherApiCall
{
    @GET("current.json")
    fun getWeather(
        @Query("q") location: String,
        @Query("lang") lang: String = "en"
    ) : Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ) : ApixuWeatherApiCall {
            val requestInterceptor = Interceptor { chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", apiKey)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiCall::class.java)
        }
    }
}