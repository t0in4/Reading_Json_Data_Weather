package com.eyehail.readingdataweather.Api

import com.eyehail.readingdataweather.Model.WeatherData
import retrofit2.Call
import retrofit2.http.GET

interface TheWeatherApiService {
    //change token and lat and lon
    @GET("weather?lat=62.035454&lon=129.675476&appid=4e9f768bcdb68a62161bd4ed2432db87")
    fun returnWeather(): Call<WeatherData>
}