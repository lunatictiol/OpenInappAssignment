package com.example.openinappassignment.repository

import android.util.Log
import com.example.openinappassignment.data.remote.ApiResponse
import com.example.openinappassignment.data.remote.OpenApi
import com.example.openinappassignment.utils.Resource


class DataRepository (
    private val api:OpenApi
){
        suspend fun getProducts(): Resource<ApiResponse> {
        val response = try {

            api.getData()

        } catch(e: Exception) {
            return Resource.Error(e)
        }
            Log.e("DATAAAA",response.data.overall_url_chart.toString())

        return Resource.Success(response)
    }

}