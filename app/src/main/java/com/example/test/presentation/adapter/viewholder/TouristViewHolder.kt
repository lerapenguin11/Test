package com.example.test.presentation.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R

class TouristViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val numberTourist : TextView = view.findViewById(R.id.tv_number_tourist)
    val btTouchArrow : ConstraintLayout = view.findViewById(R.id.bt_touch_arrow)
    val icArrow : ImageView = view.findViewById(R.id.ic_touch_arrow)
    val blockInfo : ConstraintLayout = view.findViewById(R.id.block_info_about_tourist)
}