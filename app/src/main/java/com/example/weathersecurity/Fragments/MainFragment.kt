package com.example.weathersecurity.Fragments

import android.app.ActionBar
import android.os.Bundle
import android.view.*
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.weathersecurity.API.Model.WeatherData
import com.example.weathersecurity.Fragments.Adapter.RcvAdapter
import com.example.weathersecurity.Fragments.ViewModels.MainViewModel
import com.example.weathersecurity.Fragments.ViewModels.Repo
import com.example.weathersecurity.R


class MainFragment : Fragment() {
    val myViewModel: MainViewModel = MainViewModel(repo = Repo())
    var rcvAdapter: RcvAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

//Find Views
        val root = inflater.inflate(R.layout.fragment_main_layout, null) as ViewGroup
        val temp_c_tv: TextView = root.findViewById(R.id.temp_c_tv)
        val temp_daily_tv: TextView = root.findViewById(R.id.daily_temp)
        val tv_condition: TextView = root.findViewById(R.id.tv_condition)
        val swipeLayout: SwipeRefreshLayout = root.findViewById(R.id.swipe_refresh_layout)

        fun initRecycler() {
            val recyclerView: RecyclerView = root.findViewById(R.id.rcv_hour_forecast)
            recyclerView.apply {
                layoutManager = LinearLayoutManager(
                    this@MainFragment.context, LinearLayoutManager.HORIZONTAL, false
                )

                rcvAdapter = RcvAdapter()
                adapter = rcvAdapter
            }

        }

        //observe
        fun observe() {
            myViewModel.getData().observe(this, Observer { result ->
                if (result != null) {

                    temp_c_tv.text = result.weatherData?.current?.temp_c.toString()
                    val forecast = result.weatherData?.forecast?.forecastday?.get(0)
                    temp_daily_tv.text =
                        forecast?.day?.mintemp_c.toString() + "-" + forecast?.day?.maxtemp_c.toString()
                    val condition = result.weatherData?.current?.condition?.text
                    println("$condition")
                    val currentCondition = when (condition.toString()) {
                        "Overcast" -> "Пасмурно"
                        "Cloudy" -> "Облачно"
                        "Mist" -> "Туман"
                        "Light drizzle" -> "Мелкий дождь"
                        "Partly cloudy" -> "Переменная облачность"
                        "Patchy light drizzle" -> "Кратковременный мелкий дождь"
                        "Patchy rain possible" -> "Возможен кратковременный дождь"
                        else -> "Ясно"
                    }
                    tv_condition.text = currentCondition
                    val hour = result.weatherData?.forecast?.forecastday?.get(0)?.hour
                    if (hour != null) {
                        rcvAdapter?.replaceAll(hour)
                        println(hour.get(0).temp_c.toString() + "AAAAAAAAA")
                    }


                } else println("Null Data Exception")
            })
        }
        initRecycler()
        observe()
        //Refresh
        swipeLayout.setOnRefreshListener {

            observe()
            swipeLayout.isRefreshing = false
        }
        return root
    }


}

