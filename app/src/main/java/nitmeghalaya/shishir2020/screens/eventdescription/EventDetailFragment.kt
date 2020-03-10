package nitmeghalaya.shishir2020.screens.eventdescription

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.api.load
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_event_detail.view.*
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.BaseFragment

class EventDetailFragment : BaseFragment(){

//    private val args: EventDetailFragmentArgs by navArgs()

    private val args: EventDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_detail, container, false)
        hideLoadingAnimation()
        view.apply {
            viewPager.adapter = EventDescriptionPagerAdapter(args.event, childFragmentManager)
            tabLayout.setupWithViewPager(viewPager)

            imageView.load(args.eventImage) {
                crossfade(true)
                crossfade(400)
            }

            collapsingToolbar.isTitleEnabled = true
            toolbar.title = args.eventName

            toolbar.setNavigationOnClickListener {
                findNavController().navigateUp()
            }

            appBar.addOnOffsetChangedListener(
                AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
                    if (Math.abs(verticalOffset) - appBarLayout.totalScrollRange == 0) {
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
        return view
    }
}