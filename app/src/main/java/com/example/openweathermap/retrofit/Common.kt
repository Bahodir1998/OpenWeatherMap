package com.example.openweathermap.retrofit

object Common {

    var BASE_URL = "https://api.openweathermap.org/"

    val retrofitServices: RetrofitServices
        get() = RetrofitClient.getRetrofit(BASE_URL).create(RetrofitServices::class.java)
}