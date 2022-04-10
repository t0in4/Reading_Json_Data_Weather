package com.eyehail.readingdataweather.Model

data class WeatherData(
    val name: String,
    val main: MainData,
    val weather: List<ImageData>
)
