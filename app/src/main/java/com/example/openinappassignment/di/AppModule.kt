package com.example.openinappassignment.di

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.openinappassignment.BuildConfig
import com.example.openinappassignment.data.remote.OpenApi
import com.example.openinappassignment.presentation.dashBoardScreen.DashBoardViewModel
import com.example.openinappassignment.repository.DataRepository
import com.example.openinappassignment.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
val token = BuildConfig.token

    single {
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().addInterceptor (Interceptor{ chain ->
                val request =
                    chain.request().newBuilder().addHeader("x-api-key", token)
                        .build()
                chain.proceed(request)
            }).build()
            )
            .build()
            .create(OpenApi::class.java)
    }
    factory<DataRepository> {
        DataRepository(get())
    }
    viewModel<DashBoardViewModel> {
        DashBoardViewModel(get())
    }

}