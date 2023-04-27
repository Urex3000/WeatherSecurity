package com.example.weathersecurity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weathersecurity.API.Model.WeatherData
import com.example.weathersecurity.ApiRequests.ApiRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BASE_URL = "http://api.weatherapi.com/v1/"

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getForecastData()
    }

    private fun getForecastData() {
        val api: ApiRequest = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response:Response<WeatherData> = api.getApiRequest().awaitResponse()
            if (response.isSuccessful){
                val data = response.body()!!
                Log.d(TAG, data.current?.temp_c.toString())

                withContext(Dispatchers.Main){
var a: TextView = findViewById(R.id.tv_textView)
                    a.setText(data.current?.temp_c.toString())
                }

            }
        }
    }
}


