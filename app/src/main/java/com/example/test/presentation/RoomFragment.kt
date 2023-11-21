package com.example.test.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.test.R
import com.example.test.databinding.FragmentRoomBinding
import com.example.test.presentation.adapter.RoomAdapter
import com.example.test.utilits.replaceFragmentMain
import com.example.test.viewmodel.HotelViewModel
import com.example.test.viewmodel.RoomViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoomFragment : Fragment() {
    private var _binding : FragmentRoomBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<RoomViewModel>()
    private lateinit var roomAdapter : RoomAdapter
    private var nameHotel: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nameHotel = it.getString(BUNDLE_NAME_HOTEL)
        }

        viewModel.getDataRoom()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRoomBinding.inflate(inflater, container, false)
        observeDataRoom()
        binding.icBtArrowBack.setOnClickListener{
            replaceFragmentMain(HotelFragment())
        }
        onClickListenerRoom()

        return binding.root
    }

    private fun onClickListenerRoom() {
        roomAdapter.onRoomClickListener = {
            replaceFragmentMain(BookingFragment())
        }
    }

    private fun observeDataRoom() {
        binding.titleRoom.text = nameHotel
        binding.titleRoom.isSelected = true
        roomAdapter = RoomAdapter(requireContext())
        viewModel.roomRemoteLiveData.observe(viewLifecycleOwner, Observer {room ->
            roomAdapter.submitList(room)
        })
        binding.rvRoom.adapter = roomAdapter
    }

    companion object {
        private const val BUNDLE_NAME_HOTEL = "name_hotel"
    }
}