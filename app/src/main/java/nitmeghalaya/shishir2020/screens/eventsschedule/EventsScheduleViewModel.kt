package nitmeghalaya.shishir2020.screens.eventsschedule

import androidx.lifecycle.ViewModel
import nitmeghalaya.shishir2020.model.ScheduleItem

/**
 * Created by Devansh on 6/3/20
 */

class EventsScheduleViewModel :  ViewModel() {

    fun getSchedule(): ArrayList<ScheduleItem> {
        val ScheduleItems = ArrayList<ScheduleItem>()

        ScheduleItems.add(
            ScheduleItem(
                "RANGOLI", "9:00 AM", "11:00 AM","28"
            )
        )

        ScheduleItems.add(
            ScheduleItem(
                "HARMONY", "12:00 PM", "2:00 PM","28"
            )
        )

        return ScheduleItems
    }
}