package com.example.weathersecurity.Fragments.Adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weathersecurity.Fragments.MainFragment

class ViewPagerFragmentStateAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount() =2
    override fun createFragment(position: Int) = MainFragment.newInstance(position)


}