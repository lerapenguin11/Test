package com.example.data.repository

import com.example.data.api.HotelApi
import com.example.data.mappers.HotelApiResponseMapper
import com.example.domain.common.ResultTest
import com.example.domain.entity.hotel.Hotel
import com.example.domain.entity.room.Rooms
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HotelDataSourceImpl(
    private val service : HotelApi,
    private val mapper: HotelApiResponseMapper
) : HotelDataSource
{
    override suspend fun getHotel(): ResultTest<Hotel> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getHotel()
                if (response.isSuccessful) {
                    return@withContext ResultTest.Success(mapper.toVolumeItemHotel(response.body()!!))
                } else {
                    return@withContext ResultTest.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext ResultTest.Error(e)
            }
        }

    override suspend fun getRoom(): ResultTest<List<Rooms>> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getRoom()
                if (response.isSuccessful) {
                    return@withContext ResultTest.Success(mapper.toVolumeListRoom(response.body()!!))
                } else {
                    return@withContext ResultTest.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext ResultTest.Error(e)
            }
        }
}