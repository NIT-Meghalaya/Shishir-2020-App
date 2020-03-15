package nitmeghalaya.shishir2020.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by Devansh on 15/3/20
 */

class SharedPrefRepository(context: Context) {

    companion object {
        private const val PREF_NAME = "shishir_2020"
        private const val SHOW_SCHEDULE = "show_schedule"
    }

    private val sharedPref: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var canShowSchedule: Boolean
        get() = sharedPref.getBoolean(SHOW_SCHEDULE, false)
        set(value) {
            sharedPref.edit {
                putBoolean(SHOW_SCHEDULE, value)
            }
        }
}