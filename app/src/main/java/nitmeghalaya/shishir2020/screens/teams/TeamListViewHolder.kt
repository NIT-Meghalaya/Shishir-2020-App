package nitmeghalaya.shishir2020.screens.teams
import android.view.View
import androidx.navigation.findNavController
import coil.api.load
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.item_teams_list.view.*
import nitmeghalaya.shishir2020.extensions.toJson
import nitmeghalaya.shishir2020.model.ShishirTeam
import nitmeghalaya.shishir2020.screens.BaseViewHolder
import nitmeghalaya.shishir2020.util.dpToPx

class TeamListViewHolder(itemView: View): BaseViewHolder<ShishirTeam>(itemView) {

    override fun bind(item: ShishirTeam) {
        itemView.apply {
            imageView.load(item.image) {
                val cornerRadius = dpToPx(6f, context).toFloat()
                transformations(RoundedCornersTransformation(
                    topLeft = cornerRadius, bottomLeft = cornerRadius))
            }

            teamNameTV.text = item.team

            setOnClickListener {
                val action = TeamsListFragmentDirections
                    .actionTeamsListFragmentToTeamMembersFragment(item.toJson<ShishirTeam>(), item.team)
                findNavController().navigate(action)
            }
        }
    }

}