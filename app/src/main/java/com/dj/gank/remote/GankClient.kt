package com.dj.gank.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

object GankClient {
    private val builder: OkHttpClient.Builder = OkHttpClient.Builder()

    init {
        builder.addInterceptor(HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Timber.d(message)
            }
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }

    fun instantClient(): GankApi {
        return Retrofit.Builder()
            .client(builder.build())
            .baseUrl("https://gank.io/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(GankApi::class.java)
    }
}