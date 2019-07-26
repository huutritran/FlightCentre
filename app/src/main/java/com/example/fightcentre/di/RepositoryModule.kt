package com.example.fightcentre.di

import com.example.fightcentre.data.FlightRepositoryImpl
import com.example.fightcentre.domain.FlightRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideFlightRepository(flightRepositoryImpl: FlightRepositoryImpl): FlightRepository = flightRepositoryImpl
}