package com.example.weathersecurity.API.Model

import com.example.weathersecurity.API.Model.Current
import com.example.weathersecurity.API.Model.Forecast
import com.example.weathersecurity.API.Model.Location

data class WeatherData(
    val current: Current? = null,
    val forecast: Forecast? = null,
    val location: Location? = null
)