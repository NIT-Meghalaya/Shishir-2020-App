package nitmeghalaya.shishir2020.screens.eventslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.ShishirEvent

class EventsListRecyclerViewAdapter(private val shishirEvent: List<ShishirEvent>) : RecyclerView.Adapter<EventsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EventsListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_event_list, parent, false)
    )

    override fun getItemCount() = shishirEvent.size

    override fun onBindViewHolder(holder: EventsListViewHolder, position: Int) {
        holder.bind(shishirEvent[position])
    }

}