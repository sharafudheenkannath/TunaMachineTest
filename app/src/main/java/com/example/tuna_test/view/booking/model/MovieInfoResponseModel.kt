package com.example.tuna_test.view.booking.model

data class MovieInfoResponseModel(
    val er_tickets: String,
    val grouped_movies: List<Any>,
    val movie_info: MovieInfo,
    val response: String,
    val upcoming_movies: List<UpcomingMovy>
)

data class MovieInfo(
    val Genres: String,
    val Rating: String,
    val RunTime: String,
    val ScheduledFilmId: String,
    val Synopsis: String,
    val Title: String,
    val TrailerUrl: String,
    val cast_and_crew: List<Any>,
    val coming_soon_reminder: Int,
    val date_list: List<String>,
    val image_url: String,
    val image_url_poster: String,
    val sale_on: Any,
    val show_times: List<ShowTime>,
    val slug: String
)

data class UpcomingMovy(
    val Genres: String,
    val Rating: String,
    val RunTime: String,
    val ScheduledFilmId: String,
    val Synopsis: String,
    val Title: String,
    val TrailerUrl: String,
    val image_url: String,
    val image_url_poster: String,
    val slug: String
)

data class ShowTime(
    val date: String,
    val sessions: List<Session>
)

data class Session(
    val AllowTicketSales: Boolean,
    val Attribute: String,
    val IsAllocatedSeating: Boolean,
    val ScheduledFilmId: String,
    val ScreenNumber: Int,
    val SeatsAvailable: Int,
    val SessionId: String,
    val Showtime: String,
    val ShowtimeVista: String,
    val SoldoutStatus: Int
)