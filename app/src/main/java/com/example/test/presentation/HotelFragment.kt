package com.example.test.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.test.MainActivity
import com.example.test.R
import com.example.test.databinding.FragmentHotelBinding
import com.example.test.presentation.adapter.CarouselAdapter
import com.example.test.presentation.adapter.PeculiaritiesAdapter
import com.example.test.utilits.replaceFragmentMain
import com.example.test.viewmodel.HotelViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HotelFragment : Fragment() {
    private var _binding : FragmentHotelBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<HotelViewModel>()
    private lateinit var optionAdapter : PeculiaritiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getDataHotel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        observeDataHotel()

        return binding.root
    }

    private fun numberSelectionClick(name: String) {
        binding.btNumberSelection.setOnClickListener {
            val transaction = activity?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.main_layout, newInstanceRoom(name = name))
            transaction?.commit()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun observeDataHotel() {
        viewModel.hotelRemoteLiveData.observe(viewLifecycleOwner, Observer {hotel ->
            binding.tvRating.text = "${hotel?.rating} ${hotel?.rating_name}"
            binding.tvNameHotel.text = hotel?.name
            binding.tvAdress.text = hotel?.adress
            val formattedStringPrice = StringBuilder(hotel?.minimal_price.toString())
                .insert(hotel?.minimal_price.toString().length - 3, " ").toString()
            binding.tvPrice.text = "от ${formattedStringPrice} ₽"
            binding.tvPriceForIt.text = hotel?.price_for_it
            binding.tvDescription.text = hotel?.about_the_hotel?.description
            hotel?.image_urls?.let { initCarousel(it) }
            hotel?.about_the_hotel?.peculiarities?.let { setOptionRecyclerView(it) }
            hotel?.name?.let { numberSelectionClick(it) }
        })
    }

    private fun setOptionRecyclerView(peculiarities: List<String>) {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        staggeredGridLayoutManager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
        binding.rvPeculiarities.setLayoutManager(staggeredGridLayoutManager)
        optionAdapter = PeculiaritiesAdapter()
        optionAdapter.submitList(peculiarities)
        binding.rvPeculiarities.adapter = optionAdapter
    }

    private fun initCarousel(imageUrls: List<String>) {
        val adapterViewPager = CarouselAdapter(
            requireContext(),
            imageUrls
        )
        binding.carouselLayout.viewPager.adapter = adapterViewPager
        binding.carouselLayout.dotsIndicator.setViewPager(binding.carouselLayout.viewPager)
    }

    companion object {
        private const val BUNDLE_NAME_HOTEL = "name_hotel"

        fun newInstanceRoom(name : String) =
            RoomFragment().apply {
                arguments = Bundle().apply {
                    putString(BUNDLE_NAME_HOTEL, name)
                }
            }
    }
}