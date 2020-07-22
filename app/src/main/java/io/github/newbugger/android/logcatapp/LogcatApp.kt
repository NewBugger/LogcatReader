package io.github.newbugger.android.logcatapp

import android.app.Application
import android.content.Context


class LogcatApp : Application() {

    override fun getBaseContext(): Context {
        return super.getBaseContext().also { context = it }
    }

    companion object {
        private lateinit var context: Context
        fun context(): Context = context
    }

}
