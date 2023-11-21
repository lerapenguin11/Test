package com.example.test.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.entity.Tourist
import com.example.test.R
import com.example.test.presentation.adapter.diffCallback.TouristItemDiffCallback
import com.example.test.presentation.adapter.viewholder.TouristViewHolder

class TouristAdapter : ListAdapter<Tourist, TouristViewHolder>(
    TouristItemDiffCallback()
) {
    private var checkClick = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tourist, parent, false)
        return TouristViewHolder(view)
    }

    override fun onBindViewHolder(holder: TouristViewHolder, position: Int) {
        val tourist = getItem(position)

        holder.numberTourist.text = tourist.number_tourist
        holder.btTouchArrow.setOnClickListener {
            if (checkClick){
                holder.icArrow.setImageResource(R.drawable.ic_arrow_bottom)
                holder.blockInfo.visibility = View.GONE
                checkClick = false
            } else{
                holder.icArrow.setImageResource(R.drawable.ic_arrow_top)
                holder.blockInfo.visibility = View.VISIBLE
                checkClick = true
            }
        }
    }
}