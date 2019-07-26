package com.example.fightcentre.data

import com.google.gson.annotations.SerializedName

data class Flight(

    @field:SerializedName("scheduled_duration")
    val scheduledDuration: String? = null,

    @field:SerializedName("departure_airport")
    val departureAirport: String? = null,

    @field:SerializedName("airline_code")
    val airlineCode: String? = null,

    @field:SerializedName("flight_number")
    val flightNumber: String? = null,

    @field:SerializedName("departure_date")
    val departureDate: String? = null,

    @field:SerializedName("arrival_city")
    val arrivalCity: String? = null,

    @field:SerializedName("arrival_airport")
    val arrivalAirport: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("departure_city")
    val departureCity: String? = null,

    @field:SerializedName("arrival_date")
    val arrivalDate: String? = null
)