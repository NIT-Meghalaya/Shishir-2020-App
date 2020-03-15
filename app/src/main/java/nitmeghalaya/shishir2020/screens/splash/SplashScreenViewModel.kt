package nitmeghalaya.shishir2020.screens.splash

import androidx.lifecycle.ViewModel
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.repository.SharedPrefsRepository
import splitties.toast.toast

/**
 * Created by Devansh on 15/3/20
 */

class SplashScreenViewModel(private val sharedPrefsRepository: SharedPrefsRepository): ViewModel() {

    companion object {
        private const val SHOW_SCHEDULE_REMOTE_CONFIG_KEY = "show_schedule"
        private const val REMOTE_CONFIG_FETCH_INTERVAL = 7200L
    }

    private var remoteConfig = Firebase.remoteConfig

    init {
        setUpRemoteConfig()
    }

    var isFirstStart: Boolean
        get() = sharedPrefsRepository.isFirstStart
        set(value) {
            sharedPrefsRepository.isFirstStart = value
        }

    fun getRemoteConfigValues() {
        remoteConfig.fetchAndActivate()
            .addOnSuccessListener {
                toast("Fetch succeeded")
                remoteConfig.activate()
                sharedPrefsRepository.canShowSchedule =
                    remoteConfig.getString(SHOW_SCHEDULE_REMOTE_CONFIG_KEY) == "yes"
            }.addOnFailureListener {
                toast("Fetched failed")
            }
    }

    private fun setUpRemoteConfig() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = REMOTE_CONFIG_FETCH_INTERVAL
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }
}