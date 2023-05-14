package com.example.weathersecurity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.weathersecurity.Fragments.Adapter.Adapter
import com.example.weathersecurity.Fragments.FullDailyData
import com.example.weathersecurity.Fragments.MainFragment
import com.example.weathersecurity.Fragments.ViewModels.MainViewModel
import com.example.weathersecurity.Fragments.ViewModels.Repo
import com.example.weathersecurity.databinding.ActivityMainBinding





class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
val myViewModel = MainViewModel(Repo())
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        //ViewPager start
        val myViewPager2: ViewPager2 = findViewById(R.id.main_vp)
        val myAdapter = Adapter(getSupportFragmentManager(), lifecycle);
        myAdapter.addFragment(MainFragment());
        myAdapter.addFragment(FullDailyData());
        myViewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        myViewPager2.setAdapter(myAdapter);
        //ViewPager end


    }
}

//supportFragmentManager.beginTransaction().add(R.id.container, MainFragment(), "MainFragment").commit()
