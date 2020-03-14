package nitmeghalaya.shishir2020.screens.sponsors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.SponsorList

class SponsorRecyclerViewAdapter(private val sponsorList: SponsorList) :
    RecyclerView.Adapter<SponsorViewHolder>() {

    companion object {
        const val TYPE_HEADING = "heading"
        private const val VIEW_TYPE_HEADING = 0
        private const val VIEW_TYPE_SPONSOR = 1
    }

    override fun getItemCount() = sponsorList.sponsors.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == VIEW_TYPE_SPONSOR) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_sponsor, parent, false)
            SponsorListItemViewHolder(view, viewType)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_sponsor_heading, parent, false)
            SponsorListHeadingViewHolder(view, viewType)
        }


    override fun onBindViewHolder(holder: SponsorViewHolder, position: Int) {
        val sponsorItem = sponsorList.sponsors[position]
        if (holder.type == VIEW_TYPE_HEADING)
            (holder as SponsorListHeadingViewHolder).bind(sponsorItem)
        else if (holder.type == VIEW_TYPE_SPONSOR)
            (holder as SponsorListItemViewHolder).bind(sponsorItem)
    }

    override fun getItemViewType(position: Int) =
        if (sponsorList.sponsors[position].type == TYPE_HEADING) VIEW_TYPE_HEADING
        else VIEW_TYPE_SPONSOR
}