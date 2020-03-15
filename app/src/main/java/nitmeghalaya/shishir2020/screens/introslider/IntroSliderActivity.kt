package nitmeghalaya.shishir2020.screens.introslider

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntro2
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.MainActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class IntroSliderActivity : AppIntro2() {

    private val intoSliderViewModel: IntroSliderViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.colorPrimaryDark)
        addSlides(5)
        showStatusBar(true)
        showSkipButton(false)
    }

    override fun onDonePressed(currentFragment: Fragment) {
        super.onDonePressed(currentFragment)
        intoSliderViewModel.isFirstStart = false
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun addSlides(slidesCount: Int) {
        for (i in 0 until slidesCount)  {
            addSlide(SampleSlide.newInstance(
                resources.getIdentifier("slide_$i", "layout", packageName)
            ))
        }
    }
}