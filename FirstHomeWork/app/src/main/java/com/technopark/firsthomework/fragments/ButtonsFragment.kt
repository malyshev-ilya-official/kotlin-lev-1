package com.technopark.firsthomework.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.technopark.firsthomework.R

interface OnSelectedButtonListener {
    fun onButtonSelected(buttonIndex: Int)
}

class ButtonsFragment : Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.buttons, container, false)

        val button1 = view.findViewById<Button>(R.id.button_01)
        val button2 = view.findViewById<Button>(R.id.button_02)

        button1.text = "increment"
        button2.text = "decrement"

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)

        return view
    }

    override fun onClick(p0: View?) {
        val buttonIndex = buttonIdToIndex(p0!!.id)
        Log.v("ButtonFragment", "button $buttonIndex clicked")

        val listener = activity as OnSelectedButtonListener?
        listener?.onButtonSelected(buttonIndex)
    }

    private fun buttonIdToIndex(id: Int): Int {
        var index = -1
        when (id) {
            R.id.button_01 -> index = 1
            R.id.button_02 -> index = 2
        }
        return index
    }

}