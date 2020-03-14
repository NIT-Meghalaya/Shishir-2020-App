package nitmeghalaya.shishir2020.screens.teammembers

import android.view.View
import coil.api.load
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.item_team_member_new.view.*
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.TeamMember
import nitmeghalaya.shishir2020.screens.BaseViewHolder
import nitmeghalaya.shishir2020.util.dpToPx

class TeamMemberViewHolder(itemView: View): BaseViewHolder<TeamMember>(itemView) {

    private lateinit var teamMemberItem: TeamMember

    override fun bind(item: TeamMember) {

        teamMemberItem = item

        itemView.apply {
            imageView.load(item.image) {
                transformations(RoundedCornersTransformation(dpToPx(4f, context).toFloat()))
                placeholder(R.drawable.ic_app_foreground)
                error(R.drawable.ic_app_foreground)
                crossfade(true)
                crossfade(400)
            }
        }
    }

    fun getTeamMemberItem(): TeamMember = teamMemberItem
}