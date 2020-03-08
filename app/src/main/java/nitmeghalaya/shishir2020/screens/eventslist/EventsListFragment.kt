package nitmeghalaya.shishir2020.screens.eventslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_events_list.*
import nitmeghalaya.shishir2020.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventsListFragment : Fragment() {

    private val eventsListViewModel: EventsListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        eventsListViewModel.getAllEventsList().observe(viewLifecycleOwner, Observer {
            recyclerView.adapter = EventsListRecyclerViewAdapter(it)
        })
    }
}
