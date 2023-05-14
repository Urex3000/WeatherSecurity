package com.example.weathersecurity.Fragments.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weathersecurity.API.Model.Hour
import com.example.weathersecurity.API.Model.WeatherData
import com.example.weathersecurity.R

class RcvAdapter() :
    BaseAdapter<Hour, RcvAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTime = view.findViewById<TextView>(R.id.time_tv)
        val imgCondition = view.findViewById<ImageView>(R.id.condition_image)
        val tvCondition = view.findViewById<TextView>(R.id.condition_hour_tv)
        fun bind(hour: Hour) {
            //val hour = weatherData.forecast?.forecastday?.get(0)?.hour?.get(0)
            tvTime.text = hour?.time?.takeLast(5)
            tvCondition.text = hour?.temp_c.toString()


            //Glide
            val url = hour?.condition?.icon?.replace("//", "https://")
            Glide.with(imgCondition.context)
                .load(url)
                .into(imgCondition);
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.hour_forecast_rcv_item, parent, false)
        return MyViewHolder(inflater)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }
}