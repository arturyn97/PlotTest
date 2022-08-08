package com.arturo.plottest.data.network.clients

import retrofit2.http.GET
import retrofit2.http.Query

interface DataApiClient {

    @GET("/api/v1.0/random")
    suspend fun getData(
        @Query("min") min: String, @Query("max") max: String, @Query("count") count: String
    ): List<Int>?
}