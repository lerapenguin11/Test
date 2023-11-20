package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.ResultTest
import com.example.domain.entity.hotel.Hotel
import com.example.domain.usecase.GetHotelDataUseCase
import kotlinx.coroutines.launch

class HotelViewModel(
    private val getHotelDataUseCase: GetHotelDataUseCase
) : ViewModel()
{
    private val _dataLoadingHotel = MutableLiveData(true)
    val dataLoadingHotel: LiveData<Boolean> = _dataLoadingHotel

    private val _errorHotel = MutableLiveData<String>()
    val errorHotel: LiveData<String> = _errorHotel

    private val _hotelRemote = MutableLiveData<Hotel?>()
    val hotelRemoteLiveData : MutableLiveData<Hotel?> = _hotelRemote

    fun getDataHotel() {
        viewModelScope.launch {
            _dataLoadingHotel.postValue(true)
            when (val hotelResult = getHotelDataUseCase.invoke()) {
                is ResultTest.Success -> {
                    _hotelRemote.value = hotelResult.data
                }

                is ResultTest.Error -> {
                    _dataLoadingHotel.postValue(false)
                    _errorHotel.postValue(hotelResult.exception.message)
                }
            }
        }
    }
}