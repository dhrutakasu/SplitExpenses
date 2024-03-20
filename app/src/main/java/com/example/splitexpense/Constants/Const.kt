package com.example.splitexpense.Constants

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.example.splitexpense.R

class Const {
    companion object {

        val BASE_URL: String = " "

        fun isNetwork(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val netInfo = cm.activeNetworkInfo
            return netInfo != null && netInfo.isConnectedOrConnecting
        }

        fun showNoInternetDialog(context: Context, listener: TryAgainInternet) {
            val dialog = Dialog(context)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_no_internet)
            dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val lp = dialog.window!!.attributes
            val window = dialog.window
            lp.copyFrom(window!!.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            lp.gravity = Gravity.CENTER
            window.attributes = lp
            dialog.show()
            val TvTryAgain = dialog.findViewById<TextView>(R.id.TvTryAgain)
            TvTryAgain.setOnClickListener {
                dialog.dismiss()
                listener.InternetAgainClick()
            }
        }

        interface TryAgainInternet {
            fun InternetAgainClick()
        }

    }
}