package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.model.MainViewModel

class MainActivity : AppCompatActivity() {
    //MVM - Model ViewModel (General Architecture)
    lateinit var increment: TextView   //instance
    private lateinit var mainViewModel: MainViewModel

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

    private fun setText() {
        increment.text =
            mainViewModel.count.toString()  //data is set & is pointed to txt_increment UI
    }

    private fun setTextReset() {
        increment.text = mainViewModel.count.toString()
    }

    fun clicked(view: View) {
        mainViewModel.countIncrement()
        setText()
    }

    fun reset(view: View) {
        mainViewModel.reset()
        setTextReset()
    }

}