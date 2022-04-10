package com.eyehail.readingdataweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.eyehail.readingdataweather.Api.GlideImageLoader
import com.eyehail.readingdataweather.Api.ImageLoader
import com.eyehail.readingdataweather.Api.TheWeatherApiService
import com.eyehail.readingdataweather.Model.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    private val theWeatherApiService by lazy {
        retrofit.create(TheWeatherApiService::class.java)
    }
    private val serverResponseCity : TextView by lazy {
        findViewById(R.id.city)
    }
    private val serverResponseWeather : TextView by lazy {
        findViewById(R.id.weather)
    }
    private val profileImageView: ImageView by lazy {
        findViewById(R.id.image)
    }
    private val imageLoader: ImageLoader by lazy {
        GlideImageLoader(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getWeatherResponse()
    }
    private fun getWeatherResponse() {
        val call = theWeatherApiService.returnWeather()
        call.enqueue(object: Callback<WeatherData> {
            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                Log.e("Main Activity", "Failed to get search results", t)
            }

            override fun onResponse(
                call: Call<WeatherData>,
                response: Response<WeatherData>
            ) {
                if (response.isSuccessful) {
                    val weatherResults = response.body()
                    val cityResponse = weatherResults?.name ?: "No City"
                    serverResponseCity.text = cityResponse
                    val temperatureResponse = weatherResults?.main?.temp ?: "No Temperature"
                    serverResponseWeather.text = temperatureResponse
                    Log.e("Main Activity", "https://openweathermap.org/img/wn/${weatherResults?.weather?.get(0)}@2x.png")
                    val firstImageUrl = "https://openweathermap.org/img/wn/${weatherResults?.weather?.firstOrNull()?.icon}@2x.png"
                    if (!firstImageUrl.isBlank()) {
                        imageLoader.loadImage(firstImageUrl, profileImageView)
                    } else {
                        Log.d("Main Activity", "Missing Image Url")
                    }


                } else {
                    Log.e("Main Activity", "Failed to get search results \n" +
                            "${response.errorBody()?.string() ?: ""}")
                }
            }
        })
    }
}