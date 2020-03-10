package nitmeghalaya.shishir2020.screens.eventdescription.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.TeamMember

class EventDetailTeamRecyclerViewAdapter(private val teamMembers: ArrayList<TeamMember>)
    : RecyclerView.Adapter<EventDetailTeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EventDetailTeamViewHolder(
            LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_event_detail_team, parent, false))

    override fun getItemCount() = teamMembers.size

    override fun onBindViewHolder(holder: EventDetailTeamViewHolder, position: Int) {
        holder.bind(teamMembers[position])
    }
}