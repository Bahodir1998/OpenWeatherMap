package com.example.openweathermap.retrofit

import com.example.openweathermap.models.LWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitServices {

    @POST("/data/2.5/weather?")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appid: String
    ): Call<LWeather>
}