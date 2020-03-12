package nitmeghalaya.shishir2020.screens.teammembers

import android.content.Context
import android.util.Log
import android.util.TypedValue
import android.view.View
import coil.api.load
import coil.transform.RoundedCornersTransformation
import kotlinx.android.synthetic.main.item_team_member_new.view.*
import nitmeghalaya.shishir2020.model.TeamMember
import nitmeghalaya.shishir2020.screens.BaseViewHolder


class TeamMemberViewHolder(itemView: View): BaseViewHolder<TeamMember>(itemView) {

    private lateinit var teamMemberItem: TeamMember

    override fun bind(item: TeamMember) {

        teamMemberItem = item

        itemView.apply {
            imageView.load(item.imageResId) {
                transformations(RoundedCornersTransformation(dipToPixels(context,4)))
            }
//            nameTV.text = item.name
//            postTV.text = item.position
//            emailTV.text = item.email
        }
    }

    private fun dipToPixels(context: Context, dipValue: Int): Float {
        val metrics = context.resources.displayMetrics
        val converted = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue.toFloat(), metrics)
        Log.v("Round", converted.toString())
        return converted

    }

    fun getTeamMemberItem(): TeamMember = teamMemberItem
}