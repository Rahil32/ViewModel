package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.model.MainViewModel

class MainActivity : AppCompatActivity() {
        //MVM - Model ViewModel (General Architecture)
    lateinit var increment: TextView   //instance
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        increment = findViewById(R.id.txt_increment)    //shows data
        mainViewModel =     //Object of MainViewModel
        ViewModelProvider(this).get(MainViewModel::class.java)  //proper MainViewModel Location
                    //ViewModelProvider creates object for you
        setText()
        setTextReset()

    }

    fun setText(){
        increment.text = mainViewModel.count.toString()  //data is set & is pointed to txt_increment UI
    }

    fun setTextReset(){
        increment.text = mainViewModel.resetCounter.toString()
    }

    fun clicked(view: android.view.View) {
        mainViewModel.countIncrement()
        setText()
    }

    fun Reset(view: android.view.View) {
        mainViewModel.reset()
        setTextReset()
    }

}