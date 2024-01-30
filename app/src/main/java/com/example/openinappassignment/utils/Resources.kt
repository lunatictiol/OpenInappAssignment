package com.example.openinappassignment.utils

sealed class Resource<T>( data: T? = null, exception: Exception? = null) {
    data class Success<T>( val data: T): Resource<T>(data,null)
    data class Error<T>(val exception: Exception): Resource<T>(null, exception)
}