package com.example.fightcentre.domain

import com.example.fightcentre.data.Flight
import io.reactivex.Single

interface FlightRepository {
    fun getFlightList(): Single<List<Flight>>
}