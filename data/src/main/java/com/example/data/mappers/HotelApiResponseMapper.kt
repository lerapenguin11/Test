package com.example.data.mappers

import com.example.data.api.model.booking.BookingApiResponse
import com.example.data.api.model.hotel.HotelApiResponse
import com.example.data.api.model.room.RoomApiResponse
import com.example.domain.entity.booking.Booking
import com.example.domain.entity.hotel.AboutTheHotel
import com.example.domain.entity.hotel.Hotel
import com.example.domain.entity.room.Rooms

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

    fun toVolumeListRoom(response: RoomApiResponse): List<Rooms> {
        val list = arrayListOf<Rooms>()
        for (i in response.rooms){
            val id = i.id
            val name = i.name

            val cat = Rooms(
                id = i.id,
                image_urls = i.image_urls,
                name = i.name,
                peculiarities = i.peculiarities,
                price = i.price,
                price_per = i.price_per)
            list.add(cat)
        }
        return list
    }

    fun toVolumeItemBooking(response: BookingApiResponse): Booking {
        return Booking(
             arrival_country = response.arrival_country,
             departure = response.departure,
             fuel_charge = response.fuel_charge,
             horating = response.horating,
             hotel_adress = response.hotel_adress,
             hotel_name = response.hotel_name,
             id = response.id,
             number_of_nights = response.number_of_nights,
             nutrition = response.nutrition,
             rating_name = response.rating_name,
             room = response.room,
             service_charge = response.service_charge,
             tour_date_start = response.tour_date_start,
             tour_date_stop = response.tour_date_stop,
             tour_price = response.tour_price
        )
    }
}