package com.arturo.plottest.ui.viewmodel

import android.util.Log
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

    /*Creates and returns two lists
    List 'a' contains random numbers in the range 0-100
    List 'b' contains the entries of list 'a' modulo 10
     */
    fun get_data() {
        viewModelScope.launch {
            isLoading.postValue(true)
            //Get the first 100 elements of List A
            val firstElements = getData("0", "100", "100")
            //Get the rest of the elements (900)
            val rest = IntArray(900) { (0..100).random() }.asList()
            //Merge
            val listA: ArrayList<Int> = ArrayList<Int>()
            listA.addAll(firstElements)
            listA.addAll(rest)
            Log.d("unsortedListA", listA.toString())
            //Sorting for visual improve
            listA.sort()
            Log.d("sortedListA", listA.toString())
            //Calculate List B
            val listB = listA.map { s -> s % 10 }.toList()
            Log.d("ListB", listB.toString())
            //Post List A and List B for MainActivity
            data.postValue(PlotDataModel(listA, listB))
            isLoading.postValue(false)
        }
    }

}