package nitmeghalaya.shishir2020.screens.eventdetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import coil.api.load
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_event_detail.view.*
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import kotlin.math.abs

class EventDetailFragment : Fragment(){

    private val args: EventDetailFragmentArgs by navArgs()
    private val mainViewModel: MainViewModel by sharedViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.apply {

            mainViewModel.hideLoadingAnimation()

            viewPager.adapter = EventDescriptionPagerAdapter(args.event, childFragmentManager)
            tabLayout.setupWithViewPager(viewPager)

            imageView.load(args.eventImage)
            collapsingToolbar.isTitleEnabled = true
            toolbar.title = args.eventName

            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }

            appBar.addOnOffsetChangedListener(
                AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                    if (abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
                        //  Collapsed
                        fabRegister.shrink()
                    } else {
                        //Expanded
                        fabRegister.extend()
                    }
                })

            fabRegister.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(args.registrationLink)
                context.startActivity(intent)
            }
        }
    }
}