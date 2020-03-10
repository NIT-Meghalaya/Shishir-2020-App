package nitmeghalaya.shishir2020.screens.eventsschedule

import android.view.View
import coil.api.load
import kotlinx.android.synthetic.main.fragment_event_detail_item.view.*
import kotlinx.android.synthetic.main.item_day_schedule.view.*
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.ScheduleItem
import nitmeghalaya.shishir2020.screens.BaseViewHolder

class EventDayScheduleViewHolder(view: View) : BaseViewHolder<ScheduleItem>(view) {
    override fun bind(item: ScheduleItem) {
        itemView.apply {
            startTimeTV.text = item.startTime
            endTimeTV.text = item.endTime
            titleTV.text = item.name
            imageView.load(R.drawable.technical)
        }
    }

}