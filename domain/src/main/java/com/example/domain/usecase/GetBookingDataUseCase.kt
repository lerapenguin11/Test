package com.example.domain.usecase

import com.example.domain.repository.HotelRepository

class GetBookingDataUseCase(
    private val repository: HotelRepository)
{
    suspend operator fun invoke() = repository.getBooking()
}