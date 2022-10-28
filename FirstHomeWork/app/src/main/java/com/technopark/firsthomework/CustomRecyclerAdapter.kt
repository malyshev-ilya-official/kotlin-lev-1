package com.technopark.firsthomework

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.red
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity

class CustomRecyclerAdapter(private val arr: MutableList<Int>) : RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val text: TextView = itemView.findViewById<TextView>(R.id.plateText)
        val space: ConstraintLayout = itemView.findViewById<ConstraintLayout>(R.id.plateSpace)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.plate, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return arr.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val number = position + 1

        when {
            number % 2 == 1 -> holder.space.setBackgroundColor(Color.RED)
            else -> holder.space.setBackgroundColor(Color.BLUE)
        }

        Log.v("onBindViewHolder", "$number")

        holder.text.text = number.toString()
    }

}