package com.example.splitexpense.Constants

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import com.example.splitexpense.R
import java.text.SimpleDateFormat
import java.util.Locale

class Const {
    companion object {

        val BASE_URL: String = "http://13.233.30.232:3003/"

        fun isNetwork(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (connectivityManager != null) {
                val capabilities =
                    connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                        return true
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                        Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                        return true
                    }
                }
            }
            return false
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
        fun formatDate(dateString: String): String {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            val outputFormat = SimpleDateFormat("MMM dd, yyyy", Locale.getDefault())

            try {
                val date = inputFormat.parse(dateString)
                return "Last added on ${outputFormat.format(date)}"
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return ""
        }
    }
}