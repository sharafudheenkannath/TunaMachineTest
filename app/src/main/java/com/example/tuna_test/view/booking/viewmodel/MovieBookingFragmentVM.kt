package com.example.tuna_test.view.booking.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tuna_test.base.BaseViewModel
import com.example.tuna_test.repository.TunaApiRepo
import com.example.tuna_test.util.DataResult
import com.example.tuna_test.view.booking.model.MovieInfo
import com.example.tuna_test.view.booking.model.MovieInfoReqModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieBookingFragmentVM @Inject constructor(private val repo: TunaApiRepo) : BaseViewModel() {
    val movieInfoResult = MutableLiveData<DataResult<MovieInfo>>()

    fun loadMovieInfo(movieId: String) {
        movieInfoResult.value = DataResult.loading()
        viewModelScope.launch {
            val reqData = MovieInfoReqModel("CI-tuna", "2", "5", movieId)
            val result = repo.getMovieInfo(reqData)
            if (result.isSuccessful) {
                if (result.body()!!.response == "success") {
                    movieInfoResult.value = DataResult.success(result.body()!!.movie_info)
                } else {
                    movieInfoResult.value = DataResult.error("Something went wrong !")
                }
            } else {
                movieInfoResult.value = DataResult.error("Something went wrong !")
            }
        }
    }
}