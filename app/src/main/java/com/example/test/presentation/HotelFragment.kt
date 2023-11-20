package com.example.test.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.test.databinding.FragmentHotelBinding
import com.example.test.presentation.adapter.CarouselAdapter
import com.example.test.presentation.adapter.PeculiaritiesAdapter
import com.example.test.utilits.replaceFragmentMain
import com.example.test.viewmodel.HotelViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HotelFragment : Fragment() {
    private var _binding : FragmentHotelBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<HotelViewModel>()
    private lateinit var optionAdapter : PeculiaritiesAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        viewModel.getDataHotel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        observeDataHotel()

        binding.btNumberSelection.setOnClickListener { replaceFragmentMain(RoomFragment()) }

        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun observeDataHotel() {
        viewModel.hotelRemoteLiveData.observe(viewLifecycleOwner, Observer {hotel ->
            binding.tvRating.text = "${hotel?.rating} ${hotel?.rating_name}"
            binding.tvNameHotel.text = hotel?.name
            binding.tvAdress.text = hotel?.adress
            binding.tvPrice.text = "от ${hotel?.minimal_price} ₽"
            binding.tvPriceForIt.text = hotel?.price_for_it
            binding.tvDescription.text = hotel?.about_the_hotel?.description
            hotel?.image_urls?.let { initCarousel(it) }
            hotel?.about_the_hotel?.peculiarities?.let { setOptionRecyclerView(it) }
        })
    }

    private fun setOptionRecyclerView(peculiarities: List<String>) {
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
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
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HotelFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HotelFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}