package com.example.data.repository

import com.example.domain.common.ResultTest
import com.example.domain.entity.hotel.Hotel
import com.example.domain.entity.room.Rooms
import com.example.domain.repository.HotelRepository

class HotelRepositoryImpl(
    private val dataSource: HotelDataSource
) : HotelRepository {
    override suspend fun getHotel(): ResultTest<Hotel> {
        return dataSource.getHotel()
    }

    override suspend fun getRoom(): ResultTest<List<Rooms>> {
        return dataSource.getRoom()
    }
}