package com.example.tuna_test.repository

import com.example.tuna_test.api.ApiInterface
import com.example.tuna_test.model.GetGuestTokenReqModel
import com.example.tuna_test.sharedPref.SharedPref
import com.example.tuna_test.view.authentication.model.LoginRequestModel
import com.example.tuna_test.view.booking.model.MovieInfoReqModel
import com.example.tuna_test.view.listing.model.MovieListRequestModel
import javax.inject.Inject

class TunaApiRepo @Inject constructor(private val apiInterface: ApiInterface) {
    companion object {
        const val ACCESS_TOKEN = "402620C92552D9303C58B901B43B0A41718E772C19520DD9A9AA52CE5A8FCB99"
    }

    suspend fun getGuestToken(reaData: GetGuestTokenReqModel) = apiInterface.getGuestToken(reaData)

    suspend fun login(
        reaData: LoginRequestModel
    ) = apiInterface.login("Bearer ${SharedPref.token}", ACCESS_TOKEN, "0", reaData)

    suspend fun getRoomList(reaData: MovieListRequestModel) = apiInterface.getRoomList("Bearer ${SharedPref.token}", ACCESS_TOKEN, reaData)

    suspend fun getMovieInfo(reaData: MovieInfoReqModel) = apiInterface.getMovieInfo("Bearer ${SharedPref.token}", ACCESS_TOKEN, reaData)
}