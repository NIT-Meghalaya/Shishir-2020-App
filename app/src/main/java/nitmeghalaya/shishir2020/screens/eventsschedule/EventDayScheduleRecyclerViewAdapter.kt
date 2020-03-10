package nitmeghalaya.shishir2020.screens.eventsschedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.ScheduleItem

class EventDayScheduleRecyclerViewAdapter(private val scheduleItemList: ArrayList<ScheduleItem>):
RecyclerView.Adapter<EventDayScheduleViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventDayScheduleViewHolder {
        val view=EventDayScheduleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_day_schedule,parent,false))
    return view
    }

    override fun getItemCount(): Int =scheduleItemList.size

    override fun onBindViewHolder(holder: EventDayScheduleViewHolder, position: Int) {
        holder.bind(scheduleItemList[position])
    }

}