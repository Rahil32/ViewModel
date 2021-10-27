package com.example.viewmodel.model

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {   //predefine class is inherited
    var count:Int = 0
    fun countIncrement(){
        count++
    }
}