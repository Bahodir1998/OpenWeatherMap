package com.example.openweathermap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.openweathermap.databinding.ActivityWeatherBinding
import com.example.openweathermap.retrofit.Common
import com.example.openweathermap.retrofit.RetrofitServices
import com.squareup.picasso.Picasso

class WeatherActivity : AppCompatActivity() {

    lateinit var binding: ActivityWeatherBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val latitude: Double = intent.getDoubleExtra("latitude", 0.0)
        val longitude: Double = intent.getDoubleExtra("longitude", 0.0)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.getWeather(latitude,longitude).observe(this, Observer {
            binding.locTv.setText("${it?.name}, ${it?.sys?.country}")
            binding.degree.setText("${Math.round(it?.main!!.temp - 273)}")
            Picasso.get().load("https://openweathermap.org/img/w/${it?.weather!![0].icon}.png").into(binding.icon)
            binding.sky.setText(it?.weather!![0].main)
            binding.cloudPersent.setText("${it?.clouds?.all}%")
            binding.windSpeed.setText("${it?.wind?.speed} m/s")
            binding.humidity.setText("${it?.main?.humidity}%")
            binding.pressure.setText("${it?.main?.pressure} hPa")
        })
    }
}