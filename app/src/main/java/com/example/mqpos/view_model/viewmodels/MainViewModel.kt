package com.example.qkpos.view_model.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qkpos.model.repositories.MainRepositoryImplementation
import kotlinx.coroutines.launch

class MainViewModel(var mainRepositoryImpl: MainRepositoryImplementation) : ViewModel() {
    private var _greeting = MutableLiveData<List<String>>()
    val greeting : LiveData<List<String>>
        get() = _greeting
    init{
        getGreetings()
    }
    fun getGreetings() {
        viewModelScope.launch {
            var mydata = mainRepositoryImpl.getGreetings()
            _greeting.postValue(mydata)
            Log.i("VM", mydata.toString())
        }
    }

}