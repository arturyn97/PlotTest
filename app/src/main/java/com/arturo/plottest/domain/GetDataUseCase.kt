package com.arturo.plottest.domain

import com.arturo.plottest.data.repository.DataRepo

class GetDataUseCase {
    private val repository = DataRepo()

    suspend operator fun invoke(min: String, max: String, count: String): List<Int> =
        repository.getDataFromApi(min, max, count)
}