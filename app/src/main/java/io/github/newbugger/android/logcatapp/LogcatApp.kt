package io.github.newbugger.android.logcatapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import me.weishu.reflection.Reflection


@SuppressLint("unused")
class LogcatApp : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        Reflection.unseal(this) // the dependency of shizuku as to keep there
    }

}
