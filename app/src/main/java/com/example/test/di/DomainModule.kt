package com.example.test.di

import com.example.domain.usecase.GetHotelDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetHotelDataUseCase> { GetHotelDataUseCase(
        repository = get()
    ) }
}