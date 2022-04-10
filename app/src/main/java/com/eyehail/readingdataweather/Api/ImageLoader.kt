package com.eyehail.readingdataweather.Api

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(
        imageUrl: String,
        imageView: ImageView
    )
}