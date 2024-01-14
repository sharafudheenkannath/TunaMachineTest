package com.example.tuna_test.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.tuna_test.R

object BindingUtil {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(view: ImageView, url: String?) {
        if (url.isNullOrEmpty()) {
            view.setImageResource(R.drawable.ic_logo_cinergy)
        } else {
            Glide.with(view.context).load(url).into(view)
        }
    }
}