package nitmeghalaya.shishir2020.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.screens.MainActivity

class SplashScreenActivity : AppCompatActivity() {

    val SPLASH_TIME_OUT = 6500
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)

            //Close this activity
            finish()
        }, SPLASH_TIME_OUT.toLong())
    }
}