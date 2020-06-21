package io.github.newbugger.android.logcatapp.shizuku.server

import android.os.Parcel
import android.os.RemoteException
import io.github.newbugger.android.logcatapp.shizuku.server.ShizukuSystemServer.getPackageManager
import io.github.newbugger.android.logcatapp.shizuku.server.ShizukuSystemServer.getParcelData
import moe.shizuku.api.ShizukuService


object ShizukuApi {

    // method 2: use transactRemote directly
    fun setApplicationRemote(packageName: String, permissionName: String) {
        val data = getParcelData("grantRuntimePermission").apply {
            writeString(packageName)
            writeString(permissionName)
            writeInt(0)
        }
        val reply = Parcel.obtain()
        try {
            ShizukuService.transactRemote(data, reply, 0)
            reply.readException()
        } catch (e: RemoteException) {
            e.printStackTrace()
        } finally {
            data.recycle()
            reply.recycle()
        }
    }

    // method 1: use ShizukuBinderWrapper
    fun setApplicationWrapper(packageName: String, permissionName: String) {
        try {
            getPackageManager().grantRuntimePermission(
                    packageName, permissionName, 0
            )
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

}
