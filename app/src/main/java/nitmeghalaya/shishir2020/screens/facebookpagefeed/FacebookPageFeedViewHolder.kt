package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.view.View
import coil.api.load
import kotlinx.android.synthetic.main.item_facebook_page_feed.view.*
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem
import nitmeghalaya.shishir2020.screens.BaseViewHolder
import nitmeghalaya.shishir2020.util.appendBelow
import nitmeghalaya.shishir2020.util.getBitmap
import nitmeghalaya.shishir2020.util.share

/**
 * Created by Devansh on 8/3/20
 */

class FacebookPageFeedViewHolder(itemView: View, private val viewModel: FacebookPageFeedViewModel,
                                 private val itemClickListener: FacebookFeedItemClickListener)
    : BaseViewHolder<FacebookPageFeedItem>(itemView) {

    override fun bind(item: FacebookPageFeedItem) {
        itemView.apply {
            messageTV.text = item.message

            timeTV.text = viewModel.getRelativeDateFromISO8601String(item.createdTime)

            if (item.fullPictureUrl.isNotEmpty()) {
                feedItemImage.visibility = View.VISIBLE
                feedItemImage.load(item.fullPictureUrl) {
                    placeholder(R.drawable.facebook_icon)
                }
            } else {
                feedItemImage.visibility = View.GONE
            }

            openExternalButton.setOnClickListener {
                itemClickListener.openUrlExternally(item.permalinkUrl)
            }

            shareButton.setOnClickListener {
                feedItemMainContent.apply {
                    getBitmap {
                        val shareMessageBitmap = viewModel.createFeedShareMessageBitmap(this)
                        val shareBitmap = it.appendBelow(shareMessageBitmap)
                        shareBitmap.share(context)
                    }
                }
            }
        }
    }
}