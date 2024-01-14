package com.example.tuna_test.base

import androidx.lifecycle.ViewModel
import com.example.tuna_test.util.SingleLiveEvent


abstract class BaseViewModel : ViewModel() {
    val toastMessage = SingleLiveEvent<String>()
}