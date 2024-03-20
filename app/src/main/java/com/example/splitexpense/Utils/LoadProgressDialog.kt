package com.example.splitexpense.Utils

import android.app.Activity
import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import com.example.splitexpense.R

object LoadProgressDialog {
    var dialog: Dialog? = null
    fun showDialog(activity: Activity) {
        if (dialog != null) {
            dialog!!.dismiss()
        }
        dialog = Dialog(activity)
        val inflater = LayoutInflater.from(activity)
        val mView = inflater.inflate(R.layout.layout_progress, null)
        dialog!!.setCancelable(false)
        dialog!!.setContentView(mView)
        dialog!!.window!!.setBackgroundDrawable(ColorDrawable(0))
        if (!dialog!!.isShowing && !activity.isFinishing) {
            dialog!!.show()
        }
    }

    fun hideDialog(activity: Activity?) {
        if (dialog != null && dialog!!.isShowing) {
            dialog!!.dismiss()
        }
    }
}
