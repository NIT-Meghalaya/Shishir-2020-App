package nitmeghalaya.shishir2020.screens.facebookpagefeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_shishir_page_feed.*
import nitmeghalaya.shishir2020.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class FacebookPageFeedFragment : Fragment() {

    private val facebookPageFeedViewModel: FacebookPageFeedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shishir_page_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        facebookPageFeedViewModel.getFacebookAccessToken().observe(viewLifecycleOwner, Observer {
            facebookPageFeedViewModel.getPageFeed(it.accessToken).observe(viewLifecycleOwner, Observer { feedData ->
                recyclerView.adapter = FacebookPageFeedRecyclerViewAdapter(feedData.data.filter {item ->
                    item.message.isNotEmpty()
                })
            })
        })
    }
}
