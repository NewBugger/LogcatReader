package com.dp.logcatapp.fragments.logcatlive.dialogs

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.os.Process
import androidx.appcompat.app.AlertDialog
import io.github.newbugger.android.logcatapp.R
import com.dp.logcatapp.fragments.base.BaseDialogFragment
import com.dp.logcatapp.services.LogcatService

class RestartAppMessageDialogFragment : BaseDialogFragment() {

    companion object {
        val TAG = RestartAppMessageDialogFragment::class.qualifiedName

        fun newInstance(): RestartAppMessageDialogFragment {
            return RestartAppMessageDialogFragment()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        isCancelable = false
        val getActivity = requireActivity()
        return AlertDialog.Builder(getActivity)
                .setTitle(R.string.app_restart_dialog_title)
                .setMessage(getString(R.string.app_restart_dialog_msg_body))
                .setCancelable(false)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    requireContext().stopService(Intent(requireContext(), LogcatService::class.java))
                    Process.killProcess(Process.myPid())
                }
                .create()
    }
}