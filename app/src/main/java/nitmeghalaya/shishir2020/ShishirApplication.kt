package nitmeghalaya.shishir2020

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Devansh on 5/3/20
 */

class ShishirApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShishirApplication)
        }
    }
}