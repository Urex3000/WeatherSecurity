package com.example.weathersecurity.API.Common

import com.example.weathersecurity.API.Retrofit2.RetrofitClient
import com.example.weathersecurity.API.WeatherInterface

object Common {
    //http://api.weatherapi.com/v1/forecast.json?key=e1a9d6e815f04b09834153245232003&q=Rostov-on-Don

    private val key: String = "e1a9d6e815f04b09834153245232003"
    private val BASE_URL = "http://api.weatherapi.com/v1/forecast.json?/key="
    val retrofitService: WeatherInterface
    get() = RetrofitClient.getClient(BASE_URL).create(WeatherInterface::class.java)
}