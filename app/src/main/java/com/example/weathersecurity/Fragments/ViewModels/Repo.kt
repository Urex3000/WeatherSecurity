package com.example.weathersecurity.Fragments.ViewModels

import com.example.weathersecurity.API.Model.WeatherData
import com.example.weathersecurity.ApiRequests.WeatherApi
import retrofit2.Call

class Repo() {
    companion object {
        private const val API_KEY = "e1a9d6e815f04b09834153245232003"
    }

    fun getData(query: String): Call<WeatherData> {
        val call = WeatherApi.retrofitService.getApiRequest(query, API_KEY)
        return call
    }
}