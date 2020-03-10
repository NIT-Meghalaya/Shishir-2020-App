package nitmeghalaya.shishir2020.screens.eventsschedule

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_event_schedule.view.*

import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.MainActivity

class EventsScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_event_schedule, container, false)
        (activity as MainActivity).supportActionBar?.title = "Schedule"
        view.apply {
//            viewPager.adapter = SchedulePagerAdapter(fragmentManager!!)
//            tabLayout.setupWithViewPager(viewPager)
        }
        return view
    }


}
