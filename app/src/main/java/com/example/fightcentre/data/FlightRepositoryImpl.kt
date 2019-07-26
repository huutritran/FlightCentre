package com.example.fightcentre.data

import com.example.fightcentre.domain.FlightRepository
import io.reactivex.Single
import javax.inject.Inject

class FlightRepositoryImpl @Inject constructor(private val flightService: FlightService) : FlightRepository {
    override fun getFlightList(): Single<List<Flight>> = flightService.getFlightList().firstOrError()
}