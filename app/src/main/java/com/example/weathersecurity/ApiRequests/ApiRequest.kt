package com.example.weathersecurity.ApiRequests

import com.example.weathersecurity.API.Model.WeatherData
import retrofit2.Call
import retrofit2.http.GET

interface ApiRequest {

    @GET("forecast.json?key=e1a9d6e815f04b09834153245232003&q=Rostov-on-Don")
    fun getApiRequest(): Call<WeatherData>
}