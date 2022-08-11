package com.arturo.plottest.data.repository

import com.arturo.plottest.data.network.services.DataService

class DataRepo {

    private val api = DataService()

    suspend fun getDataFromApi(min: String, max: String, count: String): List<Int> {
        return api.getData(min, max, count)
    }
}