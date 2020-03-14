package nitmeghalaya.shishir2020.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.MainActivity
import nitmeghalaya.shishir2020.screens.introslider.IntroSliderActivity

class SplashScreenActivity : AppCompatActivity() {

    val SPLASH_TIME_OUT = 6500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val getPrefs = PreferenceManager
            .getDefaultSharedPreferences(baseContext)
        val isFirstStart = getPrefs.getBoolean("firstStart", true)

        Handler().postDelayed({
//            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
//            startActivity(intent)

            if (isFirstStart) {
                startActivity(Intent(this, IntroSliderActivity::class.java))
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }

            //Close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}