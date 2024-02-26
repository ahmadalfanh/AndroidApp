package com.alfan.test.core

sealed class ApiResponse<out R> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val throwable: Exception, val code: String? = null) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}