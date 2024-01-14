package com.example.tuna_test.view.authentication.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.tuna_test.base.BaseViewModel
import com.example.tuna_test.model.GetGuestTokenReqModel
import com.example.tuna_test.repository.TunaApiRepo
import com.example.tuna_test.sharedPref.SharedPref
import com.example.tuna_test.util.SingleLiveEvent
import com.example.tuna_test.view.authentication.model.LoginRequestModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginFragmentVM @Inject constructor(private val repo: TunaApiRepo) : BaseViewModel() {
    val loginSuccess = SingleLiveEvent<Boolean>()

    init {
        viewModelScope.launch {
            val data = GetGuestTokenReqModel("CI-tuna", "2", "", "402620C92552D9303C58B901B43B0A41718E772C19520DD9A9AA52CE5A8FCB99")
            val result = repo.getGuestToken(data)
            if (result.isSuccessful) {
                SharedPref.token = result.body()!!.token
            }
        }
    }

    fun loginGuest() {
        viewModelScope.launch {
            val data = LoginRequestModel("CI-tuna", "2", "", "2", "")
            val result = repo.login(data)
            if (result.isSuccessful) {
                loginSuccess.value = result.body()!!.response == "success"
            } else {
                toastMessage.value = "Something went wrong !"
            }
        }
    }
}