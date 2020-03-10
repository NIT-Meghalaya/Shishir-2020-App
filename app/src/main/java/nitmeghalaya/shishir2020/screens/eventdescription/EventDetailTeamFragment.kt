package nitmeghalaya.shishir2020.screens.eventdescription

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nitmeghalaya.shishir2020.R

class EventDetailTeamFragment : Fragment() {

    companion object {
        private const val TEAM = "team"

        fun newInstance(team: String): EventDetailTeamFragment {
            val fragment = EventDetailTeamFragment()
            val bundle = Bundle()
            bundle.putString(TEAM, team)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_detail_team, container, false)
        return view
    }
}