package com.example.test.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entity.hotel.Hotel
import com.example.test.presentation.adapter.diffCallback.PeculiaritiesItemDiffCallback
import com.example.test.presentation.adapter.viewholder.PeculiaritiesViewHolder
import androidx.recyclerview.widget.ListAdapter
import com.example.test.R

class PeculiaritiesAdapter : ListAdapter<String, PeculiaritiesViewHolder>(
    PeculiaritiesItemDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeculiaritiesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_peculiarities, parent, false)

        return PeculiaritiesViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeculiaritiesViewHolder, position: Int) {
        val options = getItem(position)

        holder.option.text = options
    }
}