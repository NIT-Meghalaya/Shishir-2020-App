package nitmeghalaya.shishir2020.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.MainActivity
import nitmeghalaya.shishir2020.screens.introslider.IntroSliderActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreenActivity : AppCompatActivity() {

    private val splashScreenViewModel: SplashScreenViewModel by viewModel()

    companion object {
        private val SPLASH_TIME_OUT = 6500
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val isFirstStart = splashScreenViewModel.isFirstStart

        splashScreenViewModel.getRemoteConfigValues()

        Handler().postDelayed({

            if (isFirstStart) {
                startActivity(Intent(this, IntroSliderActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }

            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}