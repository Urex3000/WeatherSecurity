package com.example.weathersecurity.Fragments.ViewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weathersecurity.API.Model.Hour
import com.example.weathersecurity.API.Model.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repo: Repo) : ViewModel() {

    val liveData: MutableLiveData<Result> by lazy {
        MutableLiveData<Result>()
    }

    init {
        loadData("Rostov-on-Don")
    }

    fun loadData(query: String) {
        val call = repo.getData(query)
        call.enqueue(object : Callback<WeatherData> {
            override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {
                val data = response.body()
                if (data != null) {
                    val result: Result =
                        Result(data, "duck $query ${data.current?.temp_c.toString()}")
                    println(result.error)
                    liveData.postValue(result)
                } else {
                    val result: Result = Result(null, "Faild")
                    println(result.error)
                    liveData.postValue(result)
                }
            }

            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                val result: Result = Result(null, "Faile ${t.message}")
                t.localizedMessage?.let { Log.e("MainViewModel", it) }
                liveData.postValue(result)
            }
        })
    }

    fun getData(): LiveData<Result> {
        return liveData
    }


    data class Result(val weatherData: WeatherData?, val error: String)

}