package com.example.weathersecurity.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.window.OnBackInvokedDispatcher
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.weathersecurity.Fragments.ViewModels.MainViewModel
import com.example.weathersecurity.Fragments.ViewModels.Repo
import com.example.weathersecurity.R


class FullDailyData : Fragment() {
val myViewModel = MainViewModel(repo = Repo())
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root =
            inflater.inflate(R.layout.fragment_full_daily_data,null) as ViewGroup
        //Получение Вьюх
        val tv_one: TextView = root.findViewById(R.id.tv_fdl_first)

        //Подписка к ЛД и переача данных в вью
        myViewModel.getData().observe(this, Observer { result ->
            if (result != null) {
                val forecast = result.weatherData?.forecast?.forecastday?.get(0)
                tv_one.text = "УФ-индекс:"+forecast?.day?.uv.toString()
            } else println("Null Data Exception")
        })
        return root
    }
}