package nitmeghalaya.shishir2020.screens

import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


abstract class BaseFragment : Fragment(){
    fun setActionbarTitle(title: String) {
        (activity as MainActivity).supportActionBar?.title = title
    }

    fun hideActionBar() {
        (activity as MainActivity).supportActionBar?.hide()
    }

    fun showActionBar() {
        (activity as MainActivity).supportActionBar?.show()
    }

    fun hideLoadingAnimation() {
        (activity as MainActivity).apply {
            loading_data_animation.pauseAnimation()
            loading_data_animation.visibility = View.GONE
        }
    }

    fun showLoadingAnimation() {
        (activity as MainActivity).apply {
            loading_data_animation.playAnimation()
            navHostFragment
            loading_data_animation.visibility = View.VISIBLE
        }
    }
}