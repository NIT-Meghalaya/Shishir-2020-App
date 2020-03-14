package nitmeghalaya.shishir2020.screens.teams

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.ShishirTeam

class TeamListRecyclerViewAdapter(private val teams: List<ShishirTeam>)
    : RecyclerView.Adapter<TeamListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamListViewHolder =
        TeamListViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_teams_list, parent, false))

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamListViewHolder, position: Int) {
        holder.bind(teams[position])
    }
}