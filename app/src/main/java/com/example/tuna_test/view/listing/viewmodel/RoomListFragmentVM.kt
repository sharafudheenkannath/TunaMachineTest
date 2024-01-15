package com.example.tuna_test.view.listing.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tuna_test.base.BaseViewModel
import com.example.tuna_test.repository.TunaApiRepo
import com.example.tuna_test.util.DataResult
import com.example.tuna_test.util.SingleLiveEvent
import com.example.tuna_test.view.listing.model.EscapeRoomsMovy
import com.example.tuna_test.view.listing.model.MovieListRequestModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomListFragmentVM @Inject constructor(private val repo: TunaApiRepo) : BaseViewModel() {
    val movieListResult = MutableLiveData<DataResult<ArrayList<EscapeRoomsMovy>>>()
    val navigateToBookingPage = SingleLiveEvent<Boolean>()
    lateinit var selectedMovieData: EscapeRoomsMovy

    init {
        viewModelScope.launch {
            movieListResult.value = DataResult.loading()
            val data = MovieListRequestModel("CI-tuna", "2", "5", "")
            val result = repo.getRoomList(data)
            if (result.isSuccessful) {
                if (result.body()!!.response == "success") {
                    movieListResult.value = DataResult.success(result.body()!!.escape_rooms_movies as ArrayList<EscapeRoomsMovy>)
                } else {
                    movieListResult.value = DataResult.error("Something went wrong !")
                }
            } else {
                movieListResult.value = DataResult.error("Something went wrong !")
            }
        }
    }

    fun bookNowClick() {
        navigateToBookingPage.value = true
    }
}