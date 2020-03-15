package nitmeghalaya.shishir2020.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import nitmeghalaya.shishir2020.repository.SharedPrefsRepository

/**
 * Created by Devansh on 14/3/20
 */

class MainViewModel(private val sharedPrefsRepository: SharedPrefsRepository): ViewModel() {

    private val _bottomNavigationVisibility = MutableLiveData<Int>()
    val bottomNavigationVisibility: LiveData<Int>
        get() = _bottomNavigationVisibility

    val canShowSchedule: Boolean
        get() = sharedPrefsRepository.canShowSchedule

    fun showBottomNav(bottomNav: BottomNavigationView) {
        bottomNav.animate().translationY(0f)
    }

    fun hideBottomNav(bottomNav: BottomNavigationView) {
        bottomNav.animate().translationY(bottomNav.height.toFloat())
    }
}