package com.example.weathersecurity.API

import com.example.weathersecurity.API.Model.WeatherData
import retrofit2.Call
import retrofit2.http.GET

interface WeatherInterface {


@GET ("Rostov-on-Don")
fun getWeatherList(): Call<MutableList<WeatherData>>



}