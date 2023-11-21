package com.example.test.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.test.R
import com.example.test.databinding.FragmentBookingBinding
import com.example.test.presentation.adapter.TouristAdapter
import com.example.test.viewmodel.BookingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.slots.PredefinedSlots
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

class BookingFragment : Fragment() {
    private var _binding : FragmentBookingBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<BookingViewModel>()
    private lateinit var touristAdapter : TouristAdapter

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
        maskPhone()
        setRecyclerViewTourist()

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                if (s.toString().trim { it <= ' ' }.length == 0) {
                } else {
                    isValidEmail()
                }
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (s.toString().trim { it <= ' ' }. length == 0) {
                    isValidEmail()
                }
            }
        })

        binding.btTouchArrow.setOnClickListener {
            viewModel.addTourist()
        }

        return binding.root
    }

    private fun setRecyclerViewTourist() {
        touristAdapter = TouristAdapter()
        viewModel.touristListLD.observe(viewLifecycleOwner, Observer {
            touristAdapter.submitList(it)
        })
        binding.recyclerView.adapter = touristAdapter
    }

    private fun isValidEmail() {
        val emailPattern = Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")
        val email: String = binding.etEmail.text.toString()
        if (email.matches(emailPattern)) {
            binding.etEmail.background =
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.bg_edit_text)
        } else {
            binding.etEmail.background =
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.bg_edittext_error)
        }
    }


    private fun maskPhone() {
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        mask.isForbidInputWhenFilled = true
        mask.setPlaceholder('*')
        mask.setShowingEmptySlots(true)
        val formatWatcher: FormatWatcher = MaskFormatWatcher(mask)
        formatWatcher.installOn(binding.etPhone)
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