package com.example.tuna_test.api

import com.example.tuna_test.model.GetGuestTokenReqModel
import com.example.tuna_test.model.GetGuestTokenRespModel
import com.example.tuna_test.view.authentication.model.LoginRequestModel
import com.example.tuna_test.view.authentication.model.LoginResponseModel
import com.example.tuna_test.view.booking.model.MovieInfoReqModel
import com.example.tuna_test.view.booking.model.MovieInfoResponseModel
import com.example.tuna_test.view.listing.model.MovieListRequestModel
import com.example.tuna_test.view.listing.model.MovieListResponseModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST


interface ApiInterface {

    @POST("guestToken")
    suspend fun getGuestToken(@Body data: GetGuestTokenReqModel): Response<GetGuestTokenRespModel>

    @POST("login")
    suspend fun login(
        @Header("Authorization") authorization: String,
        @Header("accesstoken") accessToken: String,
        @Header("userid") userId: String,
        @Body data: LoginRequestModel
    ): Response<LoginResponseModel>

    @POST("escapeRoomMovies")
    suspend fun getRoomList(
        @Header("Authorization") authorization: String,
        @Header("accesstoken") accessToken: String, @Body data: MovieListRequestModel
    ): Response<MovieListResponseModel>

    @POST("getMovieInfo")
    suspend fun getMovieInfo(
        @Header("Authorization") authorization: String,
        @Header("accesstoken") accessToken: String, @Body data: MovieInfoReqModel
    ): Response<MovieInfoResponseModel>
}