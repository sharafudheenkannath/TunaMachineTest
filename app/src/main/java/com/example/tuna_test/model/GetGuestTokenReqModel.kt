package com.example.tuna_test.model

data class GetGuestTokenReqModel(
    val device_id: String,
    val device_type: String,
    val push_token: String,
    val secret_key: String
)