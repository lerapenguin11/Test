package com.example.data.repository

import androidx.lifecycle.LiveData
import com.example.domain.common.ResultTest
import com.example.domain.entity.Tourist
import com.example.domain.entity.booking.Booking
import com.example.domain.entity.hotel.Hotel
import com.example.domain.entity.room.Rooms

interface HotelRemoteSource {

    suspend fun getHotel() : ResultTest<Hotel>
    suspend fun getRoom() : ResultTest<List<Rooms>>
    suspend fun getBooking() : ResultTest<Booking>
}