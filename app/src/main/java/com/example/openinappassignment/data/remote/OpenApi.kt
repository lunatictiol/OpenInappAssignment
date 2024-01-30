package com.example.openinappassignment.data.remote

import com.example.openinappassignment.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface OpenApi{
   @GET("v1/dashboardNew/")
   @Headers("Authorization: Bearer ${BuildConfig.token}")
   suspend fun getData(): ApiResponse
}