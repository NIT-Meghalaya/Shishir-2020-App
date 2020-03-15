package nitmeghalaya.shishir2020.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import nitmeghalaya.shishir2020.R
import nitmeghalaya.shishir2020.repository.SharedPrefRepository
import splitties.toast.toast

/**
 * Created by Devansh on 14/3/20
 */

class MainViewModel(private val sharedPrefRepository: SharedPrefRepository): ViewModel() {

    private val _bottomNavigationVisibility = MutableLiveData<Int>()
    val bottomNavigationVisibility: LiveData<Int>
        get() = _bottomNavigationVisibility

    private val _scheduleMenuItemVisibility = MutableLiveData<Boolean>()
    val scheduleMenuItemVisibility: LiveData<Boolean>
        get() = _scheduleMenuItemVisibility

    companion object {
        private const val SHOW_SCHEDULE_REMOTE_CONFIG_KEY = "show_schedule"
    }

    private var remoteConfig = Firebase.remoteConfig

    init {
        setUpRemoteConfig()
        getRemoteConfigValues()
    }

    fun showBottomNav(bottomNav: BottomNavigationView) {
        bottomNav.animate().translationY(0f)
    }

    fun hideBottomNav(bottomNav: BottomNavigationView) {
        bottomNav.animate().translationY(bottomNav.height.toFloat())
    }

    private fun setUpRemoteConfig() {
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 30
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
    }

    private fun getRemoteConfigValues() {
        remoteConfig.fetchAndActivate()
            .addOnSuccessListener {
                toast("Fetch succeeded")
                remoteConfig.activate()
                _scheduleMenuItemVisibility.value = remoteConfig.getString(SHOW_SCHEDULE_REMOTE_CONFIG_KEY) == "yes"
            }.addOnFailureListener {
                toast("Fetched failed")
            }
    }
}