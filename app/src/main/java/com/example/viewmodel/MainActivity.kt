package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityMainBinding
import com.example.viewmodel.model.MainViewModel
import com.example.viewmodel.model.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    //MVM - Model ViewModel (General Architecture)
    lateinit var increment: TextView   //instance
    private lateinit var mainViewModel: MainViewModel
    lateinit var dataBinding: ActivityMainBinding

    val btnUpdate: Button
    get() = findViewById(R.id.updateLiveData)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        increment = findViewById(R.id.txt_increment)    //shows data
        mainViewModel =     //Object of MainViewModel
            ViewModelProvider(this,MainViewModelFactory(0)).get(MainViewModel::class.java)  //proper MainViewModel Location
        //ViewModelProvider creates object for you

        dataBinding.mainViewModel = mainViewModel   //main xml var is connected with mainViewModel
        dataBinding.lifecycleOwner = this    //owner is passed i.e. as long as activity runs this will work

        setText()
        setTextReset()

        btnUpdate.setOnClickListener {
            mainViewModel.liveDataUpdate()
        }

    }

    private fun setText() {
        increment.text = mainViewModel.count.toString()  //data is set & is pointed to txt_increment UI
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