package nitmeghalaya.shishir2020.screens.eventdescription

import android.os.Bundle
import androidx.fragment.app.Fragment

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

}