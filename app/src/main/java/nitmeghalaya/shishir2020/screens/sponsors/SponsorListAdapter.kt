package nitmeghalaya.shishir2020.screens.sponsors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.model.SponsorItem

class SponsorListAdapter (private val sponsorList:ArrayList<SponsorItem>): RecyclerView.Adapter<SponsorItemViewHolder>(){

    companion object {
        public const val TYPE_HEADING = "heading"
        private const val VIEW_TYPE_HEADING = 0
        private const val VIEW_TYPE_SPONSOR = 1
    }

    override fun getItemCount(): Int {
        return sponsorList.size
    }

    override fun onBindViewHolder(holder: SponsorItemViewHolder, position: Int) {
        val sponsorItem = sponsorList[position]
        if (holder.type == VIEW_TYPE_HEADING)
            (holder as SponsorListHeadingViewHolder).bind(sponsorItem)
        else if (holder.type == VIEW_TYPE_SPONSOR)
            (holder as SponsorListItemViewHolder).bind(sponsorItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == VIEW_TYPE_SPONSOR) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.sponsor_item, parent, false)
            SponsorListItemViewHolder(view, viewType)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.sponsor_heading_item, parent, false)
            SponsorListHeadingViewHolder(view, viewType)
        }

    override fun getItemViewType(position: Int) = if (sponsorList[position].type == TYPE_HEADING) VIEW_TYPE_HEADING
    else VIEW_TYPE_SPONSOR

}