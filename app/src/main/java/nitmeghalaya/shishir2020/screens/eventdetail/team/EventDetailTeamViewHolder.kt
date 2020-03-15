package nitmeghalaya.shishir2020.screens.eventdetail.team

import android.view.View
import coil.api.load
import kotlinx.android.synthetic.main.item_event_detail_team.view.*
import kotlinx.android.synthetic.main.item_event_list.view.imageView
import kotlinx.android.synthetic.main.item_event_list.view.nameTV
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.TeamMember
import nitmeghalaya.shishir2020.screens.BaseViewHolder

class EventDetailTeamViewHolder (itemView: View): BaseViewHolder<TeamMember>(itemView){
    override fun bind(item: TeamMember) {
        itemView.apply {
            imageView.load(item.image) {
                placeholder(R.mipmap.ic_launcher_foreground)
            }
            nameTV.text=item.name
            postTV.text=item.position
        }
    }

}