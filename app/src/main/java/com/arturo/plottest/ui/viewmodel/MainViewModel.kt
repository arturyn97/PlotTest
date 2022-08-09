package com.arturo.plottest.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arturo.plottest.data.model.PlotDataModel
import com.arturo.plottest.domain.GetDataUseCase
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getData = GetDataUseCase()
    val isLoading = MutableLiveData<Boolean>()
    val data = MutableLiveData<PlotDataModel>()

    fun loadChart() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val listA = getData("0", "100", "100").sorted()
            val listB = listA.map { s -> s % 10 }.toList()
            data.postValue(PlotDataModel(listA, listB))
            isLoading.postValue(false)
        }
    }

}