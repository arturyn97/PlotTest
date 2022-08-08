package com.arturo.plottest.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.randomnumberapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}