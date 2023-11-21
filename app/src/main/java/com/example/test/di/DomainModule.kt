package com.example.test.di

import com.example.domain.usecase.GetBookingDataUseCase
import com.example.domain.usecase.GetHotelDataUseCase
import com.example.domain.usecase.GetRoomDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetHotelDataUseCase> { GetHotelDataUseCase(
        repository = get()
    ) }

    factory<GetRoomDataUseCase> { GetRoomDataUseCase(
        repository = get()
    ) }

    factory<GetBookingDataUseCase> { GetBookingDataUseCase(
        repository = get()
    ) }
}