package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.view.View
import coil.api.load
import kotlinx.android.synthetic.main.item_facebook_page_feed.view.*
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import nitmeghalaya.shishir2020.screens.BaseViewHolder

/**
 * Created by Devansh on 8/3/20
 */

class FacebookPageFeedViewHolder(itemView: View): BaseViewHolder<FacebookPageFeedItem>(itemView) {

    override fun bind(item: FacebookPageFeedItem) {
        itemView.apply {
            messageTV.text = item.message

            if (item.fullPictureUrl.isNotEmpty()) {
                feedItemImage.visibility = View.VISIBLE
                feedItemImage.load(item.fullPictureUrl)
            } else {
                feedItemImage.visibility = View.GONE
            }
        }
    }
}