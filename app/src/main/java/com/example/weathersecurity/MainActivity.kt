package com.example.weathersecurity

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.weathersecurity.ApiRequests.GetForecastData
import com.example.weathersecurity.Fragments.FullDailyData



const val BASE_URL = "http://api.weatherapi.com/v1/"
private lateinit var viewPager: ViewPager2

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
supportFragmentManager.beginTransaction().add(R.id.container, FullDailyData(), "FullDailyData").commit()




    }
}


