package com.example.tuna_test.view.listing.model

data class MovieListResponseModel(
    val er_tickets: String,
    val escape_rooms_movies: List<EscapeRoomsMovy>,
    val response: String
)

data class EscapeRoomsMovy(
    val ID: String,
    val Rating: String,
    val RunTime: String,
    val ScheduledFilmId: String,
    val Synopsis: String,
    val Title: String,
    val image_url: String,
    val image_url_poster: String,
    val slug: String
)