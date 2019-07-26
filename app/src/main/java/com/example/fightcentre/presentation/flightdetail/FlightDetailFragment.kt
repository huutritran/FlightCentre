package com.example.fightcentre.presentation.flightdetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fightcentre.R

class FlightDetailFragment : Fragment() {

    companion object {
        fun newInstance() = FlightDetailFragment()
    }

    private lateinit var viewModel: FlightDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.flight_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FlightDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
