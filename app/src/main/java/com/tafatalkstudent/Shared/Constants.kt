package com.tafatalkstudent.Shared

import com.marwaeltayeb.progressdialog.ProgressDialog


object Constants {
    var isDialogShown = false
    lateinit var progress: ProgressDialog
    val isprogressInitialized get() = this::progress.isInitialized

}
