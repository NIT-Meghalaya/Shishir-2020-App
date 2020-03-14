package nitmeghalaya.shishir2020.screens.sponsors

import android.view.View
import kotlinx.android.synthetic.main.item_sponsor_heading.view.*
import nitmeghalaya.shishir2020.model.SponsorItem

class SponsorListHeadingViewHolder(view: View, override var type: Int): SponsorViewHolder(view) {

    override fun bind(item: SponsorItem) {
itemView.title.text=item.name
    }
}