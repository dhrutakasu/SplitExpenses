package com.example.splitexpense.ui.Activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitexpense.R
import com.example.splitexpense.databinding.ActivityHomeBinding
import com.example.splitexpense.databinding.ActivityMemberListBinding
import com.example.splitexpense.ui.Adapters.ListFolderAddAdapter
import com.example.splitexpense.ui.Adapters.MemberListAdapter

class MemberListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemberListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemberListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initListeners()
        initActions()
    }

    private fun initViews() {

    }

    private fun initListeners() {

    }

    private fun initActions() {
        binding.RvMemberList.layoutManager = LinearLayoutManager(this@MemberListActivity)
        binding.RvMemberList.adapter =
            MemberListAdapter(this@MemberListActivity, object : MemberListAdapter.MemberClick {
                override fun onMemberClick() {
                    val dialog = Dialog(this@MemberListActivity)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setContentView(R.layout.dlalog_bottom_view)
                    dialog.setCanceledOnTouchOutside(true)
                    dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    val lp = dialog.window!!.attributes
                    val window = dialog.window
                    lp.copyFrom(window!!.attributes)
                    lp.width = WindowManager.LayoutParams.MATCH_PARENT
                    lp.height = WindowManager.LayoutParams.WRAP_CONTENT
                    lp.gravity = Gravity.BOTTOM
                    window.attributes = lp
                    val TvQuestionName = dialog.findViewById<TextView>(R.id.TvQuestionName)
                    val TvNone = dialog.findViewById<TextView>(R.id.TvNone)
                    val Tv12Share = dialog.findViewById<TextView>(R.id.Tv12Share)
                    val Tv1Share = dialog.findViewById<TextView>(R.id.Tv1Share)
                    val Tv2Share = dialog.findViewById<TextView>(R.id.Tv2Share)
                    val Tv3Share = dialog.findViewById<TextView>(R.id.Tv3Share)
                    val TvOther = dialog.findViewById<TextView>(R.id.TvOther)
                    val TvFixed = dialog.findViewById<TextView>(R.id.TvFixed)
                    TvNone.setOnClickListener {
                        TvFixed.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv12Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv1Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv2Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv3Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvOther.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvNone.background.setColorFilter(resources.getColor(R.color.main_color), PorterDuff.Mode.SRC_IN)
                        TvFixed.isSelected = false
                        Tv12Share.isSelected = false
                        Tv1Share.isSelected = false
                        Tv2Share.isSelected = false
                        Tv3Share.isSelected = false
                        TvOther.isSelected = false
                        TvNone.isSelected = true
                        Handler().postDelayed({
//                            dialog.dismiss()
//                            Dilaogkeypad()
                        }, 500)
                    }
                    Tv12Share.setOnClickListener {
                        TvNone.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvFixed.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv1Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv2Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv3Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvOther.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv12Share.background.setColorFilter(resources.getColor(R.color.main_color), PorterDuff.Mode.SRC_IN)
                        TvNone.isSelected = false
                        TvFixed.isSelected = false
                        Tv1Share.isSelected = false
                        Tv2Share.isSelected = false
                        Tv3Share.isSelected = false
                        TvOther.isSelected = false
                        Tv12Share.isSelected = true
                        Handler().postDelayed({
//                            dialog.dismiss()
//                            Dilaogkeypad()
                        }, 500)
                    }
                    Tv1Share.setOnClickListener {
                        TvNone.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv12Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvFixed.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv2Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv3Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvOther.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv1Share.background.setColorFilter(resources.getColor(R.color.main_color), PorterDuff.Mode.SRC_IN)
                        TvNone.isSelected = false
                        Tv12Share.isSelected = false
                        TvFixed.isSelected = false
                        Tv2Share.isSelected = false
                        Tv3Share.isSelected = false
                        TvOther.isSelected = false
                        Tv1Share.isSelected = true
                        Handler().postDelayed({
//                            dialog.dismiss()
//                            Dilaogkeypad()
                        }, 500)
                    }
                    Tv2Share.setOnClickListener {
                        TvNone.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv12Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv1Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvFixed.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv3Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvOther.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv2Share.background.setColorFilter(resources.getColor(R.color.main_color), PorterDuff.Mode.SRC_IN)
                        TvNone.isSelected = false
                        Tv12Share.isSelected = false
                        Tv1Share.isSelected = false
                        TvFixed.isSelected = false
                        Tv3Share.isSelected = false
                        TvOther.isSelected = false
                        Tv2Share.isSelected = true
                        Handler().postDelayed({
                            dialog.dismiss()
                            Dilaogkeypad()
                        }, 500)
                    }
                    Tv3Share.setOnClickListener {
                        TvNone.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv12Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv1Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv2Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvFixed.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvOther.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv3Share.background.setColorFilter(resources.getColor(R.color.main_color), PorterDuff.Mode.SRC_IN)
                        TvNone.isSelected = false
                        Tv12Share.isSelected = false
                        Tv1Share.isSelected = false
                        Tv2Share.isSelected = false
                        TvFixed.isSelected = false
                        TvOther.isSelected = false
                        Tv3Share.isSelected = true
                        Handler().postDelayed({
                            dialog.dismiss()
                            Dilaogkeypad()
                        }, 500)
                    }
                    TvOther.setOnClickListener {
                        TvNone.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv12Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv1Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv2Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv3Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvOther.background.setColorFilter(resources.getColor(R.color.main_color), PorterDuff.Mode.SRC_IN)
                        TvFixed.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvNone.isSelected = false
                        Tv12Share.isSelected = false
                        Tv1Share.isSelected = false
                        Tv2Share.isSelected = false
                        Tv3Share.isSelected = false
                        TvOther.isSelected = true
                        TvFixed.isSelected = false
                        Handler().postDelayed({
                            dialog.dismiss()
                            Dilaogkeypad()
                        }, 500)
                    }
                    TvFixed.setOnClickListener {
                        TvNone.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv12Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv1Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv2Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        Tv3Share.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvOther.background.setColorFilter(resources.getColor(R.color.main_color_tab), PorterDuff.Mode.SRC_IN)
                        TvFixed.background.setColorFilter(resources.getColor(R.color.main_color), PorterDuff.Mode.SRC_IN)
                        TvNone.isSelected = false
                        Tv12Share.isSelected = false
                        Tv1Share.isSelected = false
                        Tv2Share.isSelected = false
                        Tv3Share.isSelected = false
                        TvOther.isSelected = false
                        TvFixed.isSelected = true
                        Handler().postDelayed({
                            dialog.dismiss()
                            Dilaogkeypad()
                        }, 500)
                    }
                    dialog.show()
                }
            })
        binding.LayoutTool.TvSubTitle.text = "Who benefited from it?"
        binding.LayoutTool.TvRightView.text = "Ok"

    }

    private fun Dilaogkeypad() {
        val dialog = Dialog(this@MemberListActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog_amount_keypad)
        dialog.setCanceledOnTouchOutside(true)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val lp = dialog.window!!.attributes
        val window = dialog.window
        lp.copyFrom(window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        lp.gravity = Gravity.CENTER
        window.attributes = lp
        dialog.show()
    }
}