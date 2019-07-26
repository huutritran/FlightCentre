package com.example.fightcentre.presentation.flightlist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fightcentre.data.Flight
import com.example.fightcentre.di.IOScheduler
import com.example.fightcentre.di.MainScheduler
import com.example.fightcentre.domain.GetFlightListUseCase
import com.example.fightcentre.domain.UseCase.None
import com.example.fightcentre.presentation.base.BaseViewModel
import io.reactivex.Scheduler
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

class FlightListViewModel @Inject constructor(
    private val getFlightListUseCase: GetFlightListUseCase,
    @MainScheduler private val mainScheduler: Scheduler,
    @IOScheduler private val ioScheduler: Scheduler
) : BaseViewModel() {

    private val _flightList = MutableLiveData<List<FlightItemView>>()
    val flightList: LiveData<List<FlightItemView>>
        get() = _flightList

    fun loadFlightList() {
        getFlightListUseCase(None())
            .map {
                Log.d("loadFlightList","loadFlightList ${it.size}")
                mapToSectionList(it)
            }
            .subscribeOn(ioScheduler)
            .observeOn(mainScheduler)
            .doOnSubscribe {
                isLoading.value = false
            }
            .subscribe({
                isLoading.value = false
                _flightList.value = it
            }, {
                isLoading.value = false
                errorMessage.value = it.message
            }).let { disposables.add(it) }
    }

    fun mapToSectionList(flightList: List<Flight>):List<FlightItemView> {
        val currentFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        val newFormat = "EEE, dd MMMMMM"
        val flightItemViewList = ArrayList<FlightItemView>()
        val mapSection = flightList.groupBy { flight: Flight -> changeDateFormat(currentFormat, newFormat, flight.departureDate!!) }
        mapSection.entries.forEach { entry ->
            flightItemViewList.add(Header(entry.key))
            entry.value.map { flight -> FlightItem(flight) }.let {
                flightItemViewList.addAll(it)
            }
        }
        return flightItemViewList
    }

    fun changeDateFormat(inputFormat: String, outPutFormat: String, dateString: String): String {
        val locale = Locale.getDefault()
        val originFormatter = SimpleDateFormat(inputFormat, locale)
        val newFormatter = SimpleDateFormat(outPutFormat, locale)
        val date = originFormatter.parse(dateString)
        return newFormatter.format(date)
    }
}