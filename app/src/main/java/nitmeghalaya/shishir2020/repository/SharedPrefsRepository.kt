package nitmeghalaya.shishir2020.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

/**
 * Created by Devansh on 15/3/20
 */

class SharedPrefsRepository(context: Context) {

    companion object {
        private const val PREF_NAME = "shishir_2020"
        private const val SHOW_SCHEDULE = "show_schedule"
        private const val IS_FIRST_START = "is_first_start"
    }

    private val sharedPrefs: SharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    var canShowSchedule: Boolean
        get() = sharedPrefs.getBoolean(SHOW_SCHEDULE, false)
        set(value) {
            sharedPrefs.edit {
                putBoolean(SHOW_SCHEDULE, value)
            }
        }

    var isFirstStart: Boolean
        get() = sharedPrefs.getBoolean(IS_FIRST_START, true)
        set(value) {
            sharedPrefs.edit {
                putBoolean(IS_FIRST_START, value)
            }
        }
}