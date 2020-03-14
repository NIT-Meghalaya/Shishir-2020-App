package nitmeghalaya.shishir2020.screens.sponsors

import android.view.View
import coil.api.load
import kotlinx.android.synthetic.main.item_sponsor.view.*
import nitmeghalaya.shishir2020.model.SponsorItem
import nitmeghalaya.shishir2020.screens.BaseViewHolder

abstract class SponsorViewHolder(itemView: View): BaseViewHolder<SponsorItem>(itemView) {

    abstract var type: Int
    override fun bind(item: SponsorItem) {
        itemView.imageView.load(item.imageUrl)
    }
}