package com.example.viewmodel.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData      //MainActivity -> LiveData <- MutableLiveData
import androidx.lifecycle.ViewModel      //MainActivity -> MainViewModelFactory <- MainViewModel

class MainViewModel(val start:Int) : ViewModel() {   //predefine class is inherited
    var count: Int = start   //universal/global variable

    private var liveDataFactObj = MutableLiveData<String>("Sumanta")

    val liveDataFact: LiveData<String>      //MutableLiveData -> read and write
        get() = liveDataFactObj             //LiveData -> read
                                            //Both are used together

    fun countIncrement() {                  // = is assign, : is point in var/val
        count++                             // in fun. : is return
    }

    fun reset() {                           //liveData with dataBinding is used in MVVM/ViewModel
        count = 0
    }

    fun liveDataUpdate(){
        liveDataFactObj.value = "MM MM"
    }




}