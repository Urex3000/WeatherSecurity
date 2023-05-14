package com.example.weathersecurity.ApiRequests

import android.util.Log
import android.view.View
import android.widget.TextView
import com.example.weathersecurity.API.Model.WeatherData

import com.example.weathersecurity.MainActivity
import com.example.weathersecurity.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

private val TAG = "GetForecastData"

class GetForecastData(val temp_c: TextView, val temp_day: TextView) {

    fun getForecastData() {
        val api: ApiRequest =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiRequest::class.java)


        /* GlobalScope.launch(Dispatchers.IO) {
              val response: Response<WeatherData> = api.getApiRequest("Rostov-on-Don","e1a9d6e815f04b09834153245232003").awaitResponse()
              if (response.isSuccessful){
                  val data = response.body()!!
                  Log.d(TAG, data.current?.temp_c.toString())
                  val forecast = data.forecast?.forecastday?.get(0)?.day

                       withContext(Dispatchers.Main){

                     temp_c.setText(data.current?.temp_c.toString())
                     temp_day.setText(forecast?.mintemp_c.toString()+ "—" + forecast?.maxtemp_c)

                 }
          }
      }*/
    }
}