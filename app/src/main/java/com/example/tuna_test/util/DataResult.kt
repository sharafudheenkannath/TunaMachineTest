package com.example.tuna_test.util

data class DataResult<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): DataResult<T> {
            return DataResult(Status.SUCCESS, data, null)
        }


        fun <T> error(message: String, data: T? = null): DataResult<T> {
            return DataResult(Status.ERROR, data, message)
        }

        fun <T> loading(message: String? = null): DataResult<T> {
            return DataResult(Status.LOADING, null, message)
        }
    }
}