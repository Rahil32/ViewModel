package com.example.viewmodel.model

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {   //predefine class is inherited
    var count:Int = 0   //universal/global variable
    var resetCounter:Int = 0    //universal/global variable
    fun countIncrement(){
        count++
    }
    fun reset():Int{
        return resetCounter
    }
}