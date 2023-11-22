package com.example.test.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import com.example.test.R
import com.example.test.databinding.FragmentPaymentBinding
import com.example.test.utilits.replaceFragmentMain
import kotlin.random.Random

class PaymentFragment : Fragment() {
    private var _binding : FragmentPaymentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPaymentBinding.inflate(inflater, container, false)
        setTextOrderNumber()
        setClickListener()
        return binding.root
    }

    private fun setClickListener() {
        binding.icBtArrowBack.setOnClickListener { replaceFragmentMain(BookingFragment()) }
        binding.btPay.setOnClickListener { replaceFragmentMain(HotelFragment()) }
    }

    private fun setTextOrderNumber() {
        val formattedText = getString(R.string.s_1, generateRandomNumber().toString())
        binding.textView2.text = HtmlCompat.fromHtml(formattedText, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    fun generateRandomNumber(): Int {
        val random = Random(System.currentTimeMillis())
        return random.nextInt(START_NUMBER, END_NUMBER)
    }

    companion object {
        const val START_NUMBER = 100000
        const val END_NUMBER = 999999
    }
}