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

    /*private val _remoteHotel = Hotel()
    val remoteHotel = _remoteHotel*/

    private val _errorHotel = MutableLiveData<String>()
    val errorHotel: LiveData<String> = _errorHotel

    private val _hotelList = MutableLiveData<Hotel?>()
    val hotelListLiveData : MutableLiveData<Hotel?> = _hotelList

    fun getDataHotel() {
        viewModelScope.launch {
            _dataLoadingHotel.postValue(true)
            when (val hotelResult = getHotelDataUseCase.invoke()) {
                is ResultTest.Success -> {
                   /* _remoteHotel.clear()
                    _remoteHotel.addAll(HotelResult.data)
                    _remoteHotel*/
                    _hotelList.value = hotelResult.data
                }

                is ResultTest.Error -> {
                    _dataLoadingHotel.postValue(false)
                    _errorHotel.postValue(hotelResult.exception.message)
                }
            }
        }
    }
}