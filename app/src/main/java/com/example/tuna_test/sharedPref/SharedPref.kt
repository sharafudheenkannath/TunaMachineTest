package com.example.tuna_test.sharedPref

import android.content.Context
import android.content.SharedPreferences

object SharedPref {

    private lateinit var sharedPref: SharedPreferences
    private const val TOKEN = "token"


    fun init(context: Context) {
        sharedPref = context.getSharedPreferences("Tuna", Context.MODE_PRIVATE)
    }

    var token: String
        get() = sharedPref.getString(TOKEN, "").toString()
        set(value) = sharedPref.edit().putString(TOKEN, value).apply()

}