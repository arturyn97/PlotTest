package com.arturo.plottest.data.network.services

import com.arturo.plottest.core.RetrofitHelper
import com.arturo.plottest.data.network.clients.DataApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DataService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getData(min: String, max: String, count: String): List<Int> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(DataApiClient::class.java).getData(min, max, count)
            response ?: emptyList()
        }
    }
}