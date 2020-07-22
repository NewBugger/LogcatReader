package io.github.newbugger.android.logcatapp.util

import android.content.Context
import android.os.Build
import com.dp.logcatapp.util.PreferenceKeys
import com.dp.logcatapp.util.getDefaultSharedPreferences


object PreferenceUtil {

    fun checkSdkVersion(level: Int): Boolean {
        return Build.VERSION.SDK_INT >= level
    }

    fun getPrefWorker(context: Context): Boolean {
        return prefGetString(context, PreferenceKeys.Logcat.KEY_WORKING_MODE, "1") == PreferenceKeys.Logcat.Default.WORKING_MODE
    }

    private fun prefGetString(context: Context, key: String, default: String): String {
        val pref = context.getDefaultSharedPreferences()
        return pref.getString(key, default)!!
    }

    private fun prefGetBoolean(context: Context, key: String, default: Boolean): Boolean {
        val pref = context.getDefaultSharedPreferences()
        return pref.getBoolean(key, default)
    }

    private fun prefPutBoolean(context: Context, key: String, default: Boolean) {
        val pref = context.getDefaultSharedPreferences()
        pref.edit().putBoolean(key, default).apply()
    }

}
