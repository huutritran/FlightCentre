package com.example.fightcentre.presentation.flightdetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fightcentre.R

class FlightDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.flight_detail_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, FlightDetailFragment.newInstance())
                .commitNow()
        }
    }

}
