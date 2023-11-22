package com.example.test.presentation.adapter.viewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.test.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class TouristViewHolder(view : View) : RecyclerView.ViewHolder(view){
    val numberTourist : TextView = view.findViewById(R.id.tv_number_tourist)
    val btTouchArrow : ConstraintLayout = view.findViewById(R.id.bt_touch_arrow)
    val icArrow : ImageView = view.findViewById(R.id.ic_touch_arrow)
    val blockInfo : ConstraintLayout = view.findViewById(R.id.block_info_about_tourist)
    val inputName : TextInputEditText = view.findViewById(R.id.et_name)
    val inputSurname : TextInputEditText = view.findViewById(R.id.et_surname)
    val inputDate : TextInputEditText = view.findViewById(R.id.et_date)
    val inputCitizenship : TextInputEditText = view.findViewById(R.id.et_citizenship)
    val inputPassportNumber : TextInputEditText = view.findViewById(R.id.et_passport_number)
    val inputValidityPassport : TextInputEditText = view.findViewById(R.id.et_validity_passport)
}