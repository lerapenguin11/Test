package com.example.data.repository

import com.example.domain.common.ResultTest
import com.example.domain.entity.booking.Booking
import com.example.domain.entity.hotel.Hotel
import com.example.domain.entity.room.Rooms

interface HotelDataSource {

    suspend fun getHotel() : ResultTest<Hotel>
    suspend fun getRoom() : ResultTest<List<Rooms>>
    suspend fun getBooking() : ResultTest<Booking>
}