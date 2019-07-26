package com.example.fightcentre.presentation.flightlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fightcentre.R
import java.lang.UnsupportedOperationException

class FlightAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var dataList:MutableList<FlightItemView> = mutableListOf()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = dataList.get(position)
        when (item) {
            is Header -> (holder as HeaderViewHolder).bind(item)
            is FlightItem -> (holder as FlightViewHolder).bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return when (viewType) {
            R.layout.item_date -> HeaderViewHolder(view)
            R.layout.item_flight_info -> FlightViewHolder(view)
            else -> throw UnsupportedOperationException("Unsupported this view type")
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int {
        return when(dataList.get(position)){
            is Header -> R.layout.item_date
            is FlightItem -> R.layout.item_flight_info
        }
    }

    fun updateFlightList(fligts:List<FlightItemView>){
        dataList.clear()
        dataList.addAll(fligts)
        notifyDataSetChanged()
    }

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvHeader = lazy { itemView.findViewById<TextView>(R.id.tvFlightHeader) }

        fun bind(header: Header) {
            tvHeader.value.text = header.title
        }
    }

    inner class FlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvDestination = lazy { itemView.findViewById<TextView>(R.id.tvDestination) }

        fun bind(flightItem: FlightItem) {
            tvDestination.value.text = flightItem.data.departureAirport
        }
    }
}