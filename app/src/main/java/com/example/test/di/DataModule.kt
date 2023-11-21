package com.example.test.di

import com.example.data.api.NetworkModule
import com.example.data.mappers.HotelApiResponseMapper
import com.example.data.repository.HotelRemoteSource
import com.example.data.repository.HotelRemoteSourceImpl
import com.example.data.repository.HotelRepositoryImpl
import com.example.domain.repository.HotelRepository
import com.example.test.utilits.URL
import org.koin.dsl.module


val dataModule = module {
    val networkModule by lazy {
        NetworkModule()
    }
    single<HotelRemoteSource> { HotelRemoteSourceImpl(get(), get()) }
    single<HotelRepository> { HotelRepositoryImpl(get()) }
    single { HotelApiResponseMapper() }
    single { networkModule.createHotelApi(URL) }
}