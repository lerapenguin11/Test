package com.example.test.di

import com.example.domain.usecase.GetHotelDataUseCase
import com.example.test.viewmodel.HotelViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<HotelViewModel> {
        HotelViewModel(
            getHotelDataUseCase = GetHotelDataUseCase(get())
        )
    }
}