package nitmeghalaya.shishir2020.screens.eventdetail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.gson.Gson
import nitmeghalaya.shishir2020.model.ShishirEvent

class EventDescriptionPagerAdapter(shishirEventJson: String, fm: FragmentManager) : FragmentPagerAdapter(fm){

    private val shishirEvent = Gson().fromJson(shishirEventJson, ShishirEvent::class.java)

    override fun getItem(position: Int): Fragment {
        val fragment = when (position) {
            0 -> EventDetailItemFragment.newInstance(ShishirEvent.DESCRIPTION, shishirEvent.description)
            1 -> EventDetailItemFragment.newInstance(ShishirEvent.RULES, shishirEvent.rules)
            2 -> EventDetailItemFragment.newInstance(ShishirEvent.JUDGING, shishirEvent.judging)
            3 -> {
                EventDetailTeamFragment.newInstance(shishirEvent.team)
            }else -> EventDetailTeamFragment()
        }
        return fragment
    }
    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence? =
        when (position) {
            0 -> ShishirEvent.DESCRIPTION
            1 -> ShishirEvent.RULES
            2 -> ShishirEvent.JUDGING
            3 -> ShishirEvent.TEAM
            else -> ""
        }


}