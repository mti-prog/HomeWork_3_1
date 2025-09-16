package com.geeks.homework_3_1.ext

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImg(img : String){
    Glide.with(this).load(img).into(this)
}
fun ImageView.loadGif(img : Int){
    Glide.with(this).load(img).into(this)
}