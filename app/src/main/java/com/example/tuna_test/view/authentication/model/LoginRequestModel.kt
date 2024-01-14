package com.example.tuna_test.view.authentication.model

data class LoginRequestModel(
    val device_id: String,
    val device_type: String,
    val email: String,
    val login_type: String,
    val password: String
)