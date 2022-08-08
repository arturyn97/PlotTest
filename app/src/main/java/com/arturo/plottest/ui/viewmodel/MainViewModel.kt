package com.arturo.plottest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arturo.plottest.domain.GetDataUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getData = GetDataUseCase()
    val isLoading = MutableLiveData<Boolean>()
    val data = MutableLiveData<MutableList<Int>>()

    fun loadChart() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getData("100","1000","50")
            data.postValue(result.toMutableList())
            isLoading.postValue(false)
        }
    }

}