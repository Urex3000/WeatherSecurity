package com.example.weathersecurity.Fragments

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.weathersecurity.ApiRequests.GetForecastData
import com.example.weathersecurity.Fragments.Adapter.ViewPagerFragmentStateAdapter
import com.example.weathersecurity.R


private lateinit var viewPager: ViewPager2


class MainFragmentActivity : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContentView(R.layout.activity_main)


        val textView: TextView = findViewById(R.id.tv_textView)
        GetForecastData(textView).getForecastData()


        viewPager = findViewById(R.id.viewpager)

        val pagerAdapter = ViewPagerFragmentStateAdapter(this)
        viewPager.adapter = pagerAdapter

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (viewPager.currentItem == 0) {
                    finish()
                } else {
                    viewPager.currentItem = viewPager.currentItem - 1
                }
            }

        })    */

    }


}
