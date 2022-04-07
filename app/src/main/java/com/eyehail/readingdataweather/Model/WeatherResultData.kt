package com.eyehail.readingdataweather.Model

import com.squareup.moshi.Json

data class WeatherResultData(
    @field: Json(name="name") val weatherData: WeatherData
)
