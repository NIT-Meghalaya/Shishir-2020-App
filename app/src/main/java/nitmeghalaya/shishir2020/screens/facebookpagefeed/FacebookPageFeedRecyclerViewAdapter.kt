package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.facebookpagefeed.FacebookPageFeedItem

/**
 * Created by Devansh on 8/3/20
 */

class FacebookPageFeedRecyclerViewAdapter(private val pageFeedList: List<FacebookPageFeedItem>)
    : RecyclerView.Adapter<FacebookPageFeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacebookPageFeedViewHolder =
        FacebookPageFeedViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_facebook_page_feed, parent, false))

    override fun getItemCount(): Int = pageFeedList.size

    override fun onBindViewHolder(holder: FacebookPageFeedViewHolder, position: Int) {
        holder.bind(pageFeedList[position])
    }
}