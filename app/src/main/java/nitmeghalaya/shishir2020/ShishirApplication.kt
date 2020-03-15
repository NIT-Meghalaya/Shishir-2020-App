package nitmeghalaya.shishir2020

import android.app.Application
import coil.Coil
import coil.ImageLoader
import nitmeghalaya.shishir2020.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by Devansh on 5/3/20
 */

class ShishirApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShishirApplication)
            modules(listOf(appModule, firestoreRepositoryModule, facebookPageRepositoryModule,
                facebookPageFeedDataSourceFactory, sharedPrefRepository))
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Coil.setDefaultImageLoader {
            ImageLoader.invoke(applicationContext) {
                crossfade(true)
                crossfade(300)
                placeholder(R.drawable.ic_app_foreground)
                error(R.drawable.ic_app_foreground)
            }
        }
    }
}