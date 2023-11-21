package com.example.test.presentation.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.entity.Tourist
import com.example.test.R
import com.example.test.presentation.adapter.diffCallback.TouristItemDiffCallback
import com.example.test.presentation.adapter.viewholder.TouristViewHolder
import com.google.android.material.textfield.TextInputEditText

class TouristAdapter(private val context : Context) : ListAdapter<Tourist, TouristViewHolder>(
    TouristItemDiffCallback()
) {
    private var checkClick = true
    lateinit var editTextList: List<TextInputEditText>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TouristViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tourist, parent, false)
        return TouristViewHolder(view)
    }

    override fun onBindViewHolder(holder: TouristViewHolder, position: Int) {
        val tourist = getItem(position)
        editTextList = listOf(
            holder.inputName,
            holder.inputSurname,
            holder.inputDate,
            holder.inputCitizenship,
            holder.inputPassportNumber,
            holder.inputValidityPassport
        )
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