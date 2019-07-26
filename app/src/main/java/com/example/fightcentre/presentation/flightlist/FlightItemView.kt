package com.example.fightcentre.presentation.flightlist

import com.example.fightcentre.data.Flight

sealed class FlightItemView()
data class Header(val title: String) : FlightItemView()
data class FlightItem(val data: Flight) : FlightItemView()