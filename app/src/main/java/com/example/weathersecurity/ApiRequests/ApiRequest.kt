package com.example.weathersecurity.ApiRequests

import com.example.weathersecurity.API.Model.WeatherData

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "http://api.weatherapi.com/v1/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiRequest {

    @GET("forecast.json?")
    fun getApiRequest(
        @Query("query") query: String,
        @Query("key") api_key: String,
    ): Call<WeatherData>
}

object WeatherApi {
    val retrofitService:ApiRequest by lazy {
        retrofit.create(ApiRequest::class.java)
    }
}

