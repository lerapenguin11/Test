package com.example.test.presentation.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.entity.room.Rooms
import com.example.test.R
import com.example.test.presentation.adapter.diffCallback.RoomItemDiffCallback
import com.example.test.presentation.adapter.viewholder.RoomViewHolder
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent


class RoomAdapter(
    private val context: Context)
    : ListAdapter<Rooms, RoomViewHolder>(
    RoomItemDiffCallback()) {

    var onRoomClickListener : (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(com.example.test.R.layout.item_room, parent, false)

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

        val recyclerView = holder.option
        val layoutManager = FlexboxLayoutManager(context)
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.FLEX_START
        recyclerView.layoutManager = layoutManager

        holder.btRoomNumberSelection.setOnClickListener {
            onRoomClickListener?.invoke()
        }
    }
}