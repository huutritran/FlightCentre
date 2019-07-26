package com.example.fightcentre.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.fightcentre.presentation.flightlist.FlightListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FlightListViewModel::class)
    abstract fun bindFlightListViewModel(flightListViewModel: FlightListViewModel): ViewModel
}