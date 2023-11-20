package com.example.test.presentation.adapter.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.room.Rooms

class RoomItemDiffCallback : DiffUtil.ItemCallback<Rooms>() {
    override fun areItemsTheSame(oldItem: Rooms, newItem: Rooms): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Rooms, newItem: Rooms): Boolean {
        return oldItem == newItem
    }
}