package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem

/**
 * Created by Devansh on 8/3/20
 */

class FacebookPageFeedRecyclerViewAdapter(private val viewModel: FacebookPageFeedViewModel,
                                          private val itemClickListener: FacebookFeedItemClickListener)
    : PagedListAdapter<FacebookPageFeedItem, FacebookPageFeedViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacebookPageFeedViewHolder =
        FacebookPageFeedViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_facebook_page_feed, parent, false), viewModel, itemClickListener)

    override fun onBindViewHolder(holder: FacebookPageFeedViewHolder, position: Int) {
        holder.bind(getItem(position) ?: FacebookPageFeedItem())
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<FacebookPageFeedItem>() {
            override fun areItemsTheSame(oldItem: FacebookPageFeedItem,
                                         newItem: FacebookPageFeedItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: FacebookPageFeedItem,
                                            newItem: FacebookPageFeedItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}