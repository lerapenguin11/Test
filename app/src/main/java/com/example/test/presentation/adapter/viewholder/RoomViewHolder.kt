package com.example.test.presentation.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.test.R
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val name : TextView = view.findViewById(R.id.tv_room_name)
    val price : TextView = view.findViewById(R.id.tv_price_room)
    val price_per : TextView = view.findViewById(R.id.tv_price_per)
    val viewPager : ViewPager = view.findViewById(R.id.viewPager)
    val dotsIndicator : DotsIndicator = view.findViewById(R.id.dots_indicator)
    val option : RecyclerView = view.findViewById(R.id.rv_peculiarities_room)
}