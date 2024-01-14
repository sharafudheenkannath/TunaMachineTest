package com.example.tuna_test.model

data class GetGuestTokenRespModel(
    val attractions_menu: Int,
    val food_menu: Int,
    val id: Int,
    val location: Any,
    val printer_name: Any,
    val response: String,
    val token: String
)