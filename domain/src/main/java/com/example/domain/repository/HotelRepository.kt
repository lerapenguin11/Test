package com.example.domain.repository

import com.example.domain.common.ResultTest
import com.example.domain.entity.Tourist
import com.example.domain.entity.booking.Booking
import com.example.domain.entity.hotel.Hotel
import com.example.domain.entity.room.Rooms

interface HotelRepository {
    suspend fun getHotel() : ResultTest<Hotel>
    suspend fun getRoom() : ResultTest<List<Rooms>>
    suspend fun getBooking() : ResultTest<Booking>
}