package nitmeghalaya.shishir2020.screens.teams
import android.view.View
import androidx.navigation.findNavController
import coil.api.load
//import kotlinx.android.synthetic.main.item_teams_list.view.*
import kotlinx.android.synthetic.main.item_teams_list.view.*
//import nitmeghalaya.shishir2020.extensions.toJson
import nitmeghalaya.shishir2020.model.ShishirTeam
import nitmeghalaya.shishir2020.screens.BaseViewHolder
import toJson

class TeamViewHolder(itemView: View): BaseViewHolder<ShishirTeam>(itemView) {

    override fun bind(item: ShishirTeam) {
        itemView.apply {
            imageView.load(item.image)
            teamNameTV.text = item.team

            setOnClickListener {
                val action = TeamsListFragmentDirections
                    .actionTeamsListFragmentToTeamMembersFragment(item.toJson<ShishirTeam>())
                findNavController().navigate(action)
            }
        }
    }
}