package com.example.fightcentre.data

import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FlightService @Inject constructor(retrofit: Retrofit) : FlightApi {
    private val flightApi by lazy { retrofit.create(FlightApi::class.java) }

    override fun getFlightList() = flightApi.getFlightList()
}