package com.technopark.firsthomework.fragments

import android.app.ActivityManager
import android.app.PendingIntent.getActivity
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.app.ActivityManagerCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity
import com.technopark.firsthomework.CustomRecyclerAdapter
import com.technopark.firsthomework.R

class PlatesFragment : Fragment() {

    private lateinit var information: TextView
    private lateinit var reciclerView: RecyclerView
    private val platesList = emptyList<Int>().toMutableList()

    private var plateAmount: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.plates, container, false)

        plateAmount = savedInstanceState?.getInt("platesAmount") ?: 0

        val configuration = resources.configuration.orientation
        val colAmount = when (configuration) {
            Configuration.ORIENTATION_PORTRAIT -> { 3 }
            else -> { 4 }
        }

        information = view.findViewById<TextView>(R.id.information)

        reciclerView = view.findViewById<RecyclerView>(R.id.platesRecyclerView)
        reciclerView.layoutManager = GridLayoutManager(view.context, colAmount)
        reciclerView.adapter = CustomRecyclerAdapter(platesList)

        return view
    }

    override fun onStart() {
        super.onStart()
        this.updatePlates()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("platesAmount", plateAmount)
    }

    fun incPlateAmount() {
        plateAmount += 1
        this.updatePlates()
    }

    fun decPlateAmount() {
        plateAmount -= 1
        if (plateAmount < 0) {
            plateAmount = 0
        }
        this.updatePlates()
    }

    fun updatePlates() {
        information.text = plateAmount.toString()

        while (platesList.size < plateAmount) {
            platesList.add(platesList.size + 1)
            reciclerView.adapter?.notifyItemInserted(platesList.size - 1)
        }

        while (platesList.size > plateAmount) {
            platesList.removeLast()
            reciclerView.adapter?.notifyItemRemoved(platesList.size)
        }
    }

}
