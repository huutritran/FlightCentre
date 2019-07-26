package com.example.fightcentre

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.fightcentre.presentation.flightlist.FlightAdapter
import com.example.fightcentre.presentation.flightlist.FlightListViewModel
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var flightListViewModel: FlightListViewModel

    private val adapter = lazy { FlightAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        flightListViewModel = ViewModelProviders.of(this, viewModelFactory).get(FlightListViewModel::class.java)
        rvFlight.adapter = adapter.value

        with(flightListViewModel) {
            flightList.observe(this@MainActivity, Observer {
                adapter.value.updateFlightList(it)
                Log.d("MainActivity", "Success ${it.size}")
            })
            errorMessage.observe(this@MainActivity, Observer {
                Log.d("MainActivity", "Failed $it")
            })

            isLoading.observe(this@MainActivity, Observer {

            })
        }
        flightListViewModel.loadFlightList()
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}
