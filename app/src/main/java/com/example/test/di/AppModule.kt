package com.example.test.di

import com.example.domain.usecase.GetHotelDataUseCase
import com.example.domain.usecase.GetRoomDataUseCase
import com.example.test.viewmodel.HotelViewModel
import com.example.test.viewmodel.RoomViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<HotelViewModel> {
        HotelViewModel(
            getHotelDataUseCase = GetHotelDataUseCase(get())
        )
    }

    viewModel<RoomViewModel> {
        RoomViewModel(
            getRoomDataUseCase = GetRoomDataUseCase(get())
        )
    }
}