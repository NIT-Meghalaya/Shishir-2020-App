package nitmeghalaya.shishir2020.screens.eventslist

import android.view.View
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.item_event_list.view.*
import nitmeghalaya.shishir2020.extensions.toJson
import nitmeghalaya.shishir2020.model.ShishirEvent
import nitmeghalaya.shishir2020.screens.BaseViewHolder

class EventsListViewHolder (itemView: View) : BaseViewHolder<ShishirEvent>(itemView){

    override fun bind(item: ShishirEvent) {
        itemView.apply {
            nameTV.text = item.name
        }
    }

//    private fun navigateToEventDetails(view: View, item: ShishirEvent) {
//        val action = EventsListFragmentDirections
//            .actionEventsFragmentToEventDetailFragment(
//                item.toJson<ShishirEvent>(), item.name, item.image, item.registrationLink)
//        view.findNavController().navigate(action)
//    }

}