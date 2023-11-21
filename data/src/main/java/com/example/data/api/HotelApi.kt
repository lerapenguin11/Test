package com.example.data.api

import com.example.data.api.model.booking.BookingApiResponse
import com.example.data.api.model.hotel.HotelApiResponse
import com.example.data.api.model.room.RoomApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface HotelApi {

    @GET("v3/d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotel(): Response<HotelApiResponse>

    @GET("v3/8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getRoom(): Response<RoomApiResponse>

    @GET("v3/63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBooking(): Response<BookingApiResponse>
}