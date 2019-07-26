package com.example.fightcentre.data

import io.reactivex.Observable
import retrofit2.http.GET

interface FlightApi {
    @GET("b/flight-centre-brand.appspot.com/o/developer-test-flights-list.json?alt=media&token=81d93056-9c7f-451d-94b6-3e88eb6fa9ad")
    fun getFlightList():Observable<List<Flight>>
}