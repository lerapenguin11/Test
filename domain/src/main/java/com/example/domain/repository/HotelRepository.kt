package com.example.domain.repository

import com.example.domain.common.ResultTest
import com.example.domain.entity.hotel.Hotel

interface HotelRepository {

    suspend fun getHotel() : ResultTest<List<Hotel>>
}