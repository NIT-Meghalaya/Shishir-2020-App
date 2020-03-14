package nitmeghalaya.shishir2020.screens.introslider

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import com.github.paolorotolo.appintro.AppIntro2
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.MainActivity

class IntroSliderActivity : AppIntro2() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.colorPrimaryDark)

        addSlide(
            SampleSlide.newInstance(
                R.layout.slide_0
            )
        )
        addSlide(
            SampleSlide.newInstance(
                R.layout.slide_1
            )
        )
        addSlide(
            SampleSlide.newInstance(
                R.layout.slide_2
            )
        )
        addSlide(
            SampleSlide.newInstance(
                R.layout.slide_3
            )
        )
        addSlide(
            SampleSlide.newInstance(
                R.layout.slide_4
            )
        )

        showStatusBar(true)
        showSkipButton(false)
    }

    override fun onDonePressed(currentFragment: Fragment) {
        val e = PreferenceManager
            .getDefaultSharedPreferences(baseContext).edit()
        e.putBoolean("firstStart", false)
        e.apply()
        startActivity(Intent(this, MainActivity::class.java))

        super.onDonePressed(currentFragment)
        finish()
    }
}