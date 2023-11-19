package com.example.domain.usecase

import com.example.domain.repository.HotelRepository

class GetHotelDataUseCase (
    private val repository : HotelRepository)
{
    suspend operator fun invoke() = repository.getHotel()
}