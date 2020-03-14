package nitmeghalaya.shishir2020.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*


abstract class BaseFragment : Fragment() {

    private lateinit var mActivity: MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mActivity = activity as MainActivity
    }

    fun setActionbarTitle(title: String) {
        mActivity.supportActionBar?.title = title
    }

    fun hideActionBar() {
        mActivity.supportActionBar?.hide()
    }

    fun showActionBar() {
        mActivity.supportActionBar?.show()
    }

    fun hideLoadingAnimation() {
        mActivity.apply {
            loading_data_animation.pauseAnimation()
            loading_data_animation.visibility = View.GONE
        }
    }

    fun showLoadingAnimation() {
        mActivity.apply {
            loading_data_animation.playAnimation()
            navHostFragment
            loading_data_animation.visibility = View.VISIBLE
        }
    }

    fun hideBottomNavView() {
    }
}