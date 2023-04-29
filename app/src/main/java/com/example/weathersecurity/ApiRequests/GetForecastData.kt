package com.example.weathersecurity.ApiRequests

import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.weathersecurity.API.Model.WeatherData
import com.example.weathersecurity.BASE_URL
import com.example.weathersecurity.MainActivity
import com.example.weathersecurity.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
private val TAG = "GetForecastData"
class GetForecastData(val a: TextView) {

     fun getForecastData() {
        val api: ApiRequest = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response: Response<WeatherData> = api.getApiRequest().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                Log.d(TAG, data.current?.temp_c.toString())

                withContext(Dispatchers.Main){

                    var a: TextView = a
                    a.setText(data.current?.temp_c.toString())
                }

            }
        }
    }

}