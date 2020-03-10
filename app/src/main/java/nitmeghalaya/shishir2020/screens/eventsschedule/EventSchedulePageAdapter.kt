package nitmeghalaya.shishir2020.screens.eventsschedule

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class EventSchedulePageAdapter (fm : FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    override fun getItem(position: Int): Fragment =when(position){
        0 -> EventDayScheduleFragment()
        1 -> EventDayScheduleFragment()
        2 -> EventDayScheduleFragment()
        else -> EventDayScheduleFragment()
    }


    override fun getCount() = 3

    override fun getPageTitle(position: Int) =
        when(position){
            0 -> "March 26"
                1-> "March 27"
            2-> "March 28"
            else -> ""
        }



}