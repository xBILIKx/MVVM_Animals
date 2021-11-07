package com.example.mvvm_animals

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun<T: Context> ImageView.loadGifOrImage(model: T, url: String){
    val isGif = Regex("\\.gif$").containsMatchIn(url)
    if(isGif)
        Glide.with(model).asGif().load(url).into(this)
    else
        Glide.with(model).asBitmap().load(url).into(this)
}