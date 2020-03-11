package nitmeghalaya.shishir2020.screens.sponsors

import android.view.View
import kotlinx.android.synthetic.main.sponsor_heading_item.view.*
import nitmeghalaya.shishir2020.model.SponsorItem
import nitmeghalaya.shishir2020.screens.BaseViewHolder

class SponsorListHeadingViewHolder(view: View, override var type: Int): SponsorItemViewHolder(view) {

    override fun bind(item: Any) {
        item as SponsorItem

        view.title.text = item.name
    }
}