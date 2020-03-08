package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.view.View
import kotlinx.android.synthetic.main.item_facebook_page_feed.view.*
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import nitmeghalaya.shishir2020.screens.BaseViewHolder

/**
 * Created by Devansh on 8/3/20
 */

class FacebookPageFeedViewHolder(itemView: View): BaseViewHolder<FacebookPageFeedItem>(itemView) {

    override fun bind(item: FacebookPageFeedItem) {
        itemView.messageTV.text = item.message
    }
}