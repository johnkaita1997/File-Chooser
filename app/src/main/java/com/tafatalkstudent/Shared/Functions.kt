package com.tafatalkstudent.Shared

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.*
import android.widget.*
import com.tafatalkstudent.R
import com.tafatalkstudent.Shared.Constants.isDialogShown
import com.tafatalkstudent.Shared.Constants.isprogressInitialized
import com.tafatalkstudent.Shared.Constants.progress
import java.util.*
import kotlin.coroutines.CoroutineContext


fun Context.showAlertDialog(message: String) {
    val alert = AlertDialog.Builder(this).setTitle("File Chooser").setCancelable(false).setMessage(message).setIcon(R.drawable.common_google_signin_btn_icon_dark).setPositiveButton("", DialogInterface.OnClickListener { dialog, _ ->
        isDialogShown = false
        dialog.dismiss()
    }).setNegativeButton("OKAY", DialogInterface.OnClickListener { dialog, _ ->
        dialog.dismiss()
        isDialogShown = false
    })
    if (!isDialogShown) {
        alert.show()
        isDialogShown = true
    }
}


fun Context.showProgress(activity: Activity) {
    progress = com.marwaeltayeb.progressdialog.ProgressDialog(activity).setDialogPadding(50).setTextSize(18F).setProgressBarColor(R.color.propdarkblue).setText("").setCancelable(false).setDialogTransparent()
    if (!progress.isShowing) {
        progress.show()
    }
}

fun Context.dismissProgress() {
    if (isprogressInitialized) {
        if (progress.isShowing) {
            progress.dismiss()
        }
    }
}



