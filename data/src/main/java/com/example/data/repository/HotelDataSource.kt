package com.example.data.repository

import com.example.domain.common.ResultTest
import com.example.domain.entity.hotel.Hotel

interface HotelDataSource {

    suspend fun getHotel() : ResultTest<Hotel>
}