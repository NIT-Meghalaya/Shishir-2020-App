package nitmeghalaya.shishir2020.screens.introslider

import androidx.lifecycle.ViewModel
import nitmeghalaya.shishir2020.repository.SharedPrefsRepository

/**
 * Created by Devansh on 15/3/20
 */

class IntroSliderViewModel(private val sharedPrefsRepository: SharedPrefsRepository): ViewModel() {

    var isFirstStart: Boolean
        get() = sharedPrefsRepository.isFirstStart
        set(value) {
            sharedPrefsRepository.isFirstStart = value
        }
}