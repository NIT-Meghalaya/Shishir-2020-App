package nitmeghalaya.shishir2020.screens.eventsschedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_event_day_schedule.*
import nitmeghalaya.shishir2020.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventDayScheduleFragment : Fragment(){

    private val viewModel: EventsScheduleViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_event_day_schedule,container,false)

        view.apply {
            scheduleRecyclerView.apply {
                adapter = EventDayScheduleRecyclerViewAdapter(viewModel.getSchedule())
                layoutManager = LinearLayoutManager(context)
            }
        }

        return view
    }

}