package nitmeghalaya.shishir2020.screens.eventslist

import android.view.View
import androidx.navigation.findNavController
import coil.api.load
import kotlinx.android.synthetic.main.item_event_list.view.*
import nitmeghalaya.shishir2020.model.ShishirEvent
import nitmeghalaya.shishir2020.screens.BaseViewHolder
import toJson

class EventsListViewHolder(itemView: View) : BaseViewHolder<ShishirEvent>(itemView) {

    override fun bind(item: ShishirEvent) {
        itemView.apply {
            nameTV.text = item.name
            imageView.load(item.image) {
                crossfade(true)
                crossfade(500)
            }
            setOnClickListener { (navigateToEventDetails(it, item)) }

            buttonExplore.setOnClickListener{(navigateToEventDetails(it,item))}
        }
    }

    private fun navigateToEventDetails(view: View, item: ShishirEvent) {
        val action = EventsListFragmentDirections
            .actionEventsListFragmentToEventDetailFragment(
                item.toJson<ShishirEvent>(), item.name, item.image, item.registrationLink
            )
        view.findNavController().navigate(action)
    }

}