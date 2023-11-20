package com.example.data.mappers

import com.example.data.api.model.HotelApiResponse
import com.example.domain.entity.hotel.AboutTheHotel
import com.example.domain.entity.hotel.Hotel

class HotelApiResponseMapper {

    fun toVolumeItemHotel(response: HotelApiResponse): Hotel {
        return Hotel(
            about_the_hotel = AboutTheHotel(
                description = response.about_the_hotel.description,
                peculiarities = response.about_the_hotel.peculiarities
            ),
            adress = response.adress,
            id = response.id,
            image_urls = response.image_urls,
            minimal_price = response.minimal_price,
            name = response.name,
            price_for_it = response.price_for_it,
            rating = response.rating,
            rating_name = response.rating_name
        )
    }
}