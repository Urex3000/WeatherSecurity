package com.example.weathersecurity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weathersecurity.API.Model.WeatherData

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tCelcium = WeatherData().current?.temp_c.toString()
        val text: TextView  = findViewById(R.id.textMainContent)
        text.setText(tCelcium)

    }


}