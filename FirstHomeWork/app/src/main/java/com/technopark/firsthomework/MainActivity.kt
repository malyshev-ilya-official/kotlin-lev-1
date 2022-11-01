package com.technopark.firsthomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.technopark.firsthomework.fragments.OnSelectedButtonListener
import com.technopark.firsthomework.fragments.PlatesFragment

class MainActivity : AppCompatActivity(), OnSelectedButtonListener {

    private var platesAmount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onButtonSelected(buttonIndex: Int) {
        val fragmentManager = supportFragmentManager
        val platesFragment = fragmentManager.findFragmentById(R.id.plates_fragment) as PlatesFragment?

        when(buttonIndex) {
            1 -> platesFragment?.incPlateAmount()
            2 -> platesFragment?.decPlateAmount()
        }
    }
}