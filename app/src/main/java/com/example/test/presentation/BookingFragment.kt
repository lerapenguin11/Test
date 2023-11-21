package com.example.test.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.test.databinding.FragmentBookingBinding
import com.example.test.viewmodel.BookingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookingFragment : Fragment() {
    private var _binding : FragmentBookingBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<BookingViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDataBooking()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBookingBinding.inflate(inflater, container, false)
        observeDataBooking()

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun observeDataBooking() {
        viewModel.bookingRemoteLiveData.observe(viewLifecycleOwner, Observer {booking ->
            binding.tvRating.text = "${booking?.horating} ${booking?.rating_name}"
            binding.tvNameHotel.text = booking?.hotel_name
            binding.tvAdress.text = booking?.hotel_adress
            binding.tvDeparture.text = booking?.departure
            binding.tvCity.text = booking?.arrival_country
            binding.tvDate.text = "${booking?.tour_date_start} - ${booking?.tour_date_stop}"
            binding.tvCount.text = "${booking?.number_of_nights} $NIGHT"
            binding.tvHotel.text = booking?.hotel_name
            binding.tvRoom.text = booking?.room
            binding.tvNutrition.text = booking?.nutrition
            binding.tvTour.text =
                "${viewModel.formattedStringPrice(booking?.tour_price.toString())} $CURRENCY"
            binding.tvFuelCollection.text =
                "${viewModel.formattedStringPrice(booking?.fuel_charge.toString())} $CURRENCY"
            binding.tvServiceFee.text =
                "${viewModel.formattedStringPrice(booking?.service_charge.toString())} $CURRENCY"
            val pay = "${viewModel.formattedStringPrice(
                viewModel.getPayment(
                booking?.tour_price,
                booking?.fuel_charge,
                booking?.service_charge).toString())} $CURRENCY"
            binding.tvToBePaid.text = pay
            binding.btPay.text = "$PAY ${pay}"
        })
    }


    companion object {
        const val NIGHT = "ночей"
        const val CURRENCY = "₽"
        const val PAY = "Оплатить"
    }
}