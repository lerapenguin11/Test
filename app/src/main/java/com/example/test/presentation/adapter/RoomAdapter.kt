package com.example.test.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entity.room.Rooms
import androidx.recyclerview.widget.ListAdapter
import com.example.test.R
import com.example.test.presentation.adapter.diffCallback.RoomItemDiffCallback
import com.example.test.presentation.adapter.viewholder.RoomViewHolder

class RoomAdapter(
    private val context: Context)
    : ListAdapter<Rooms, RoomViewHolder>(
    RoomItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room, parent, false)

        return RoomViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val room = getItem(position)

        holder.name.text = room.name
        val formattedStringPrice = StringBuilder(room.price.toString())
            .insert(room.price.toString().length - 3, " ").toString()
        holder.price.text = "${formattedStringPrice} ₽"
        holder.price_per.text = room.price_per

        val adapterViewPager = CarouselAdapter(
            context = context,
            room.image_urls
        )
        holder.viewPager.adapter = adapterViewPager
        holder.dotsIndicator.setViewPager(holder.viewPager)
        val peculiaritiesAdapter = PeculiaritiesAdapter()
        peculiaritiesAdapter.submitList(room.peculiarities)
        holder.option.adapter = peculiaritiesAdapter
    }
}