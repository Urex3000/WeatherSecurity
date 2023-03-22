package com.example.weathersecurity.API.Model

data class Forecastday(
    val astro: Astro? = null,
    val date: String? = null,
    val date_epoch: Int? = null,
    val day: Day? = null,
    val hour: List<Hour>? = null
)