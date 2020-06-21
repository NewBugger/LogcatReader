package io.github.newbugger.android.logcatapp.shizuku.server

import android.content.pm.IPackageManager
import android.os.Parcel
import io.github.newbugger.android.logcatapp.shizuku.connect.Singleton
import moe.shizuku.api.ShizukuBinderWrapper
import moe.shizuku.api.SystemServiceHelper


object ShizukuSystemServer {

    fun getParcelData(type: String): Parcel {
        // Parcel used for each once, as cannot be cached
        return SystemServiceHelper.obtainParcel(
                "package",
                "android.content.pm.IPackageManager",
                type
        )
    }

    fun getPackageManager(): IPackageManager {
        return pm.get()
    }

    private val pm = object : Singleton<IPackageManager>() {
        override fun create(): IPackageManager {
            return IPackageManager.Stub.asInterface(
                    ShizukuBinderWrapper(
                            SystemServiceHelper.getSystemService("package")
                    )
            )
        }
    }

}
