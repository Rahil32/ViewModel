package com.example.viewmodel.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//MainActivity (var start) -> MainViewModel through MainViewModelFactory
class MainViewModelFactory(val start:Int): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(start) as T    //'T' is Generic function i.e it has no specific type
    }

}