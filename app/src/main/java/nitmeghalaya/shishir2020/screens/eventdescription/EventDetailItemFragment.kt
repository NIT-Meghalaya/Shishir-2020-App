package nitmeghalaya.shishir2020.screens.eventdescription

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.SpannableString
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_event_detail_item.view.*
import nitmeghalaya.shishir2020.R

class EventDetailItemFragment : Fragment(){

   companion object {

        const val TITLE = "title"
        const val DESCRIPTION = "description"

        fun newInstance(title: String, description: String): EventDetailItemFragment {
            val fragment = EventDetailItemFragment()
            val args = Bundle()
            args.putString(TITLE, title)
            args.putString(DESCRIPTION, description)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var title: String
    private lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(TITLE) ?:""
        description= arguments?.getString(DESCRIPTION) ?:""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_event_detail_item, container, false)

        view.apply {
            titleTV.text = fromHtml(title)
            descriptionTV.text = fromHtml(description)
        }

        return view
    }

    private fun fromHtml(html: String?): Spanned {
        return when {
            html == null -> {
                // return an empty spannable if the html is null
                SpannableString("")
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                // FROM_HTML_MODE_LEGACY is the behaviour that was used for versions below android N
                // we are using this flag to give a consistent behaviour
                Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
            }
            else -> Html.fromHtml(html)
        }
    }

}