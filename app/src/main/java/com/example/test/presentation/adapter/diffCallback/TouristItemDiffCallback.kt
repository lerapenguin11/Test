package com.example.test.presentation.adapter.diffCallback

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.entity.Tourist

class TouristItemDiffCallback : DiffUtil.ItemCallback<Tourist>() {

    override fun areItemsTheSame(oldItem: Tourist, newItem: Tourist): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Tourist, newItem: Tourist): Boolean {
        return oldItem == newItem
    }
}