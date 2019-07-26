package com.example.fightcentre.domain

import com.example.fightcentre.data.Flight
import io.reactivex.Single
import javax.inject.Inject

class GetFlightListUseCase @Inject constructor(
    private val flightRepository: FlightRepository
) : UseCase<UseCase.None, Single<List<Flight>>>() {

    override fun invoke(param: None): Single<List<Flight>> = flightRepository.getFlightList()

}