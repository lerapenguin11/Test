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
    val blockName : TextInputLayout = view.findViewById(R.id.text_input_name)
    val inputName : TextInputEditText = view.findViewById(R.id.et_name)
    val blockSurname : TextInputLayout = view.findViewById(R.id.text_input_surname)
    val inputSurname : TextInputEditText = view.findViewById(R.id.et_surname)
    val blockDate : TextInputLayout = view.findViewById(R.id.text_input_date)
    val inputDate : TextInputEditText = view.findViewById(R.id.et_date)
    val blockCitizenship : TextInputLayout = view.findViewById(R.id.text_input_citizenship)
    val inputCitizenship : TextInputEditText = view.findViewById(R.id.et_citizenship)
    val blockPassportNumber : TextInputLayout = view.findViewById(R.id.text_input_passport_number)
    val inputPassportNumber : TextInputEditText = view.findViewById(R.id.et_passport_number)
    val blockValidityPassport : TextInputLayout = view.findViewById(R.id.text_input_validity_passport)
    val inputValidityPassport : TextInputEditText = view.findViewById(R.id.et_validity_passport)
}