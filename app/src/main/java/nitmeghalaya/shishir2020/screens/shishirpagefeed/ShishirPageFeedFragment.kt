package nitmeghalaya.shishir2020.screens.shishirpagefeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_shishir_page_feed.*
import nitmeghalaya.shishir2020.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShishirPageFeedFragment : Fragment() {

    private val shishirPageFeedViewModel: ShishirPageFeedViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_shishir_page_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shishirPageFeedViewModel.getFacebookAccessToken().observe(viewLifecycleOwner, Observer {
            shishirPageFeedViewModel.getPageFeed(it.accessToken).observe(viewLifecycleOwner, Observer {feedData ->
                textView.text = feedData.toString()
            })
        })
    }
}
