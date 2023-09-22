package com.sajal.weatherapp.base

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.sajal.weatherapp.network.UrlConstants

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("image_url")
    fun ImageView.bindImage(iconName: String?) {
        iconName?.let {
            Glide
                .with(this.context)
                .load(UrlConstants.WEATHER_ICON_URL.format(iconName))
                .fitCenter()
                .into(this)
        }
    }
}