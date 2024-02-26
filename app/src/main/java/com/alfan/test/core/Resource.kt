package com.alfan.test.core

sealed class Resource<T>(val data: T? = null, val message: String? = null, val code: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null, code: String? = null) : Resource<T>(data, message, code)
}