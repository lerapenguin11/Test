package com.example.test.presentation

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.test.R
import com.example.test.databinding.FragmentHotelBinding
import com.example.test.presentation.adapter.CarouselAdapter
import java.util.Timer
import java.util.TimerTask

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HotelFragment : Fragment() {
    private var _binding : FragmentHotelBinding? = null
    private val binding get() = _binding!!
    private lateinit var stringList : ArrayList<String>


    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHotelBinding.inflate(inflater, container, false)
        initCarousel()

        return binding.root
    }

    private fun initCarousel() {
        //TODO delete
        stringList = ArrayList<String>()
        stringList.add("https://avatars.mds.yandex.net/get-altay/374295/2a0000015b1791c294a596d0698883284a49/orig")
        stringList.add("https://romani-hotel.ru/wp-content/uploads/2020/01/ihks7gw2vgyv-nazvany-5-samykh-griaznykh-predmetov-v-nomerakh-ot.jpg")
        val adapterViewPager = CarouselAdapter(
            requireContext(),
            stringList
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