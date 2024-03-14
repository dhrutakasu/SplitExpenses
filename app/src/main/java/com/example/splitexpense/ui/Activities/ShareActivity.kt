package com.example.splitexpense.ui.Activities

import android.app.Dialog
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import com.example.splitexpense.R
import com.example.splitexpense.blurkit.BlurryLayout
import com.example.splitexpense.databinding.ActivityImportMemberBinding
import com.example.splitexpense.databinding.ActivityShareBinding

class ShareActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        initListeners()
        initActions()
    }

    private fun initViews() {

    }

    private fun initListeners() {
        binding.IvBackHome.setOnClickListener {
           finish()
        }
        binding.TvCreatePasswordPopup.setOnClickListener {
            val dialog = Dialog(this@ShareActivity)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.dialog_create_password)
            dialog.setCanceledOnTouchOutside(true)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            val lp = dialog.window!!.attributes
            val window = dialog.window
            lp.copyFrom(window!!.attributes)
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.MATCH_PARENT
            lp.gravity = Gravity.CENTER
            window.attributes = lp
            val IvCancelPassword = dialog.findViewById<ImageView>(R.id.IvCancelPassword)
            IvCancelPassword.setOnClickListener {
                dialog.dismiss()
            }
            val BlurrysShare=dialog.findViewById<BlurryLayout>(R.id.BlurrysShare)
            val BlurryBitmap=BitmapFactory.decodeResource(resources,R.drawable.share_screen,)
            BlurrysShare.setBitmapBlur(BlurryBitmap)
            dialog.show()
        }
    }

    private fun initActions() {

    }
}