package nitmeghalaya.shishir2020.screens.sponsors

import android.view.View
import coil.api.load
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import nitmeghalaya.shishir2020.model.SponsorItem
import kotlinx.android.synthetic.main.sponsor_item.view.*
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.BaseViewHolder


class SponsorListItemViewHolder(view: View, override var type: Int): SponsorItemViewHolder(view) {

    override fun bind(item: Any) {
        item as SponsorItem

        view.apply {
            val options = RequestOptions().placeholder(R.drawable.loading)
            Glide.with(this).load(item.imageUrl).apply(options).into(sponsorImage)
        }
    }
}