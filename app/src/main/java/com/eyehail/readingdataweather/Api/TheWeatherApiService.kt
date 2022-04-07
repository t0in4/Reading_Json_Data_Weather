package com.eyehail.readingdataweather.Api

import com.eyehail.readingdataweather.Model.WeatherData
import retrofit2.Call
import retrofit2.http.GET

interface TheWeatherApiService {
    //change token and lat and lon
    @GET("weather?lat=00&lon=00&appid={token}")
    fun returnWeather(): Call<WeatherData>
}