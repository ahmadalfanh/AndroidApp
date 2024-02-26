package com.alfan.test.utils.view

import android.app.Dialog
import android.content.Context
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import com.alfan.test.R

class LoadingDialog {
    var mDialog: Dialog? = null
    fun showLoading(con: Context?) {
        if (con == null) return
        mDialog = Dialog(con, R.style.ProgressDialog)
        mDialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mDialog?.window?.setBackgroundDrawableResource(R.color.semi_transparent_gray)
        mDialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        mDialog?.setContentView(R.layout.progress_view)
        mDialog?.show()
    }
}