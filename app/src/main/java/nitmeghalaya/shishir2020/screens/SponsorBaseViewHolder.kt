package nitmeghalaya.shishir2020.screens

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SponsorBaseViewHolder(protected val view: View): RecyclerView.ViewHolder(view) {

    abstract fun bind(item: Any)
}