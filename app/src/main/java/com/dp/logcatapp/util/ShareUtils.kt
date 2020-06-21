package com.dp.logcatapp.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.core.net.toFile
import io.github.newbugger.android.logcatapp.BuildConfig
import io.github.newbugger.android.logcatapp.R

object ShareUtils {
    fun shareSavedLogs(context: Context, uri: Uri, isCustom: Boolean): Boolean {
        try {
            val intent = Intent(Intent.ACTION_SEND)

            val shareUri = if (isCustom) {
                uri
            } else {
                FileProvider.getUriForFile(context,
                        "${context.packageName}.${BuildConfig.FILE_PROVIDER}", uri.toFile())
            }

            intent.setDataAndType(shareUri, "text/plain")
            intent.putExtra(Intent.EXTRA_STREAM, shareUri)
            intent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION

            context.startActivity(Intent.createChooser(intent, context.getString(R.string.share)))
            return true
        } catch (e: Exception) {
            context.showToast(context.getString(R.string.unable_to_share))
            return false
        }
    }
}