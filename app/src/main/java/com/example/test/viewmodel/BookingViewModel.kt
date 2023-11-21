package com.example.test.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.common.ResultTest
import com.example.domain.entity.booking.Booking
import com.example.domain.usecase.GetBookingDataUseCase
import kotlinx.coroutines.launch

class BookingViewModel(
    private val getBookingDataUseCase: GetBookingDataUseCase
) : ViewModel()
{
    private val _dataLoadingBooking = MutableLiveData(true)
    val dataLoadingBooking: LiveData<Boolean> = _dataLoadingBooking

    private val _errorBooking = MutableLiveData<String>()
    val errorBooking: LiveData<String> = _errorBooking

    private val _bookingRemote = MutableLiveData<Booking?>()
    val bookingRemoteLiveData : MutableLiveData<Booking?> = _bookingRemote

    fun getDataBooking() {
        viewModelScope.launch {
            _dataLoadingBooking.postValue(true)
            when (val bookingResult = getBookingDataUseCase.invoke()) {
                is ResultTest.Success -> {
                    _bookingRemote.value = bookingResult.data
                }

                is ResultTest.Error -> {
                    _dataLoadingBooking.postValue(false)
                    _errorBooking.postValue(bookingResult.exception.message)
                }
            }
        }
    }

    fun formattedStringPrice(toString: String): String {
        return StringBuilder(toString)
            .insert(toString.length - 3, " ").toString()
    }

    fun getPayment(tour : Int?, fuel : Int?, service : Int?) : Int?{
        return tour!! + fuel!! + service!!
    }
}