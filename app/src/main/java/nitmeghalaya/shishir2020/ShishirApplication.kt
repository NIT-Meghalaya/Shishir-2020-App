package nitmeghalaya.shishir2020

import android.app.Application
import nitmeghalaya.shishir2020.di.appModule
import nitmeghalaya.shishir2020.di.facebookPageFeedDataSourceFactory
import nitmeghalaya.shishir2020.di.facebookPageRepositoryModule
import nitmeghalaya.shishir2020.di.firestoreRepositoryModule
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
                facebookPageFeedDataSourceFactory))
        }

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}