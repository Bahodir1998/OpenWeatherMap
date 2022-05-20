package com.example.openweathermap

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.openweathermap.models.LWeather
import com.example.openweathermap.retrofit.Common.retrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    val appId = "b50625b42995398c01c34ce3493ca6d1"
    private val liveData = MutableLiveData<LWeather>()

    fun getWeather(latitude: Double, longitude: Double): LiveData<LWeather> {
        retrofitServices.getWeather(latitude, longitude, appId).enqueue(object : Callback<LWeather> {
                override fun onResponse(call: Call<LWeather>, response: Response<LWeather>) {
                    if (response.isSuccessful){
                        liveData.value = response.body()
                    }
                }
                override fun onFailure(call: Call<LWeather>, t: Throwable) {
                }
            })
        return liveData
    }
}