package com.example.weathersecurity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.weathersecurity.Fragments.Adapter.ViewPagerFragmentStateAdapter
import com.example.weathersecurity.Fragments.MainFragment
import com.example.weathersecurity.databinding.ActivityMainBinding


const val BASE_URL = "http://api.weatherapi.com/v1/"


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val viewPager2 = binding?.mainVp
        val adapter= ViewPagerFragmentStateAdapter(this)
        viewPager2?.adapter = adapter

    }
}

//supportFragmentManager.beginTransaction().add(R.id.container, MainFragment(), "MainFragment").commit()
