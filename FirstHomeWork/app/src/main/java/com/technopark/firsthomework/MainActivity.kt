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

        platesAmount = savedInstanceState?.getInt("platesAmount") ?: 0
    }

    override fun onStart() {
        super.onStart()
        val fragmentManager = supportFragmentManager
        val platesFragment = fragmentManager.findFragmentById(R.id.plates_fragment) as PlatesFragment?
        platesFragment?.setPlates(platesAmount)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.v("MainActivityLog", "onSaveInstanceState")

        outState.putInt("platesAmount", platesAmount)
    }

    override fun onButtonSelected(buttonIndex: Int) {
        val fragmentManager = supportFragmentManager

        platesAmount = when(buttonIndex) {
            1 -> platesAmount + 1
            2 -> when {
                platesAmount - 1 < 0 -> 0
                else -> platesAmount - 1
            }
            else -> platesAmount
        }

        val platesFragment = fragmentManager.findFragmentById(R.id.plates_fragment) as PlatesFragment?
        platesFragment?.setPlates(platesAmount)
    }
}