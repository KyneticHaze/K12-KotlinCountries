package com.example.kotlincountries.util

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.kotlincountries.R

/// Extension function
// glide için bir extension function oluşturacağız
fun ImageView.getImageWithGlide(url: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.drawable.ic_launcher_background)

    Glide
        .with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun placeholderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        this.strokeWidth = 8f
        this.centerRadius = 40f
        start()
    }
}
@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView, url: String?) {
    view.getImageWithGlide(url, placeholderProgressBar(view.context))
}