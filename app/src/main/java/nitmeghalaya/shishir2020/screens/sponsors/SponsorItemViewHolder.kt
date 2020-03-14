package nitmeghalaya.shishir2020.screens.sponsors

import android.view.View
import coil.api.load
import kotlinx.android.synthetic.main.item_sponsor.view.*
import nitmeghalaya.shishir2020.model.SponsorItem

class SponsorListItemViewHolder(view: View, override var type: Int): SponsorViewHolder(view) {

    override fun bind(item: SponsorItem) {
        itemView.imageView.load(item.imageUrl)
    }
}