package com.example.qkpos.view_model.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.qkpos.model.repositories.MainRepositoryImplementation

class MainViewModelFactory(val mainRepositoryImplementation: MainRepositoryImplementation) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        return modelClass.getConstructor(MainRepositoryImplementation::class.java)
            .newInstance(mainRepositoryImplementation)
    }
}