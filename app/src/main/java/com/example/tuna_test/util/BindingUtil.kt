package com.example.tuna_test.util

import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object BindingUtil {

    @BindingAdapter("imageUrl")
    @JvmStatic
    fun setImageUrl(view: ImageView, url: String?) {
        if (url.isNullOrEmpty()) {
        } else {
            Glide.with(view.context).load(url).into(view)
        }
    }

    @BindingAdapter("convertMovieShowDate")
    @JvmStatic
    fun setMovieShowDate(view: AppCompatTextView, text: String) {
        val formatter = DateTimeFormatter.ofPattern("MMMM dd")
        val date = LocalDate.parse(text).format(formatter)
        view.text = date
    }

    @BindingAdapter("convertMovieShowDay")
    @JvmStatic
    fun setMovieShowDay(view: AppCompatTextView, text: String) {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val date = LocalDate.parse(text, formatter)

        // Getting the day of the week
        val dayOfWeek = date.dayOfWeek.toString()
        view.text = dayOfWeek.take(3)
    }
}