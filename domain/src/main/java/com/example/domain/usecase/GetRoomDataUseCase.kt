package com.example.domain.usecase

import com.example.domain.repository.HotelRepository

class GetRoomDataUseCase (private val repository : HotelRepository){
    suspend operator fun invoke() = repository.getRoom()
}