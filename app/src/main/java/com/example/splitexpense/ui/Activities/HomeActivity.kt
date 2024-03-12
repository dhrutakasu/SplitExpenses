package com.example.splitexpense.ui.Activities

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.example.splitexpense.R
import com.example.splitexpense.Utils.BlurTransformation
import com.example.splitexpense.databinding.ActivityHomeBinding
import com.example.splitexpense.ui.Adapters.ExpenseAdapter
import com.example.splitexpense.ui.Adapters.ListFolderAddAdapter
import com.example.splitexpense.ui.Adapters.PersonDataAdapter
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import jp.wasabeef.blurry.Blurry


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
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
        binding.RvListAndFolder.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.RvListAndFolder.adapter =
            ListFolderAddAdapter(this@HomeActivity, object : ListFolderAddAdapter.ListFolderClick {
                override fun onFolderClick() {
                    binding.ConsHomeView.visibility = View.GONE
                    binding.ConsToolBar.visibility = View.GONE
                    binding.ConsWithShape.visibility = View.VISIBLE
                    binding.ConsExpenseMembers.visibility = View.GONE
                    binding.ConsMembers.visibility = View.GONE
                    binding.RvExpense.visibility = View.VISIBLE
                    binding.ScrollAmountRupee.visibility = View.GONE
                    binding.ConsAddExpense.visibility = View.GONE
                    binding.ConsBlur.visibility = View.VISIBLE

//                    Glide.with(this@HomeActivity).load(R.drawable.blur).apply(
//                        bitmapTransform(
//                            BlurTransformation(this@HomeActivity)
//                        )
//                    ).into(binding.IvBlur)
//                    Blurry.with(this@HomeActivity)
//                        .radius(25)
//                        .sampling(2)
//                        .async()
//                        .animate(500)
//                        .onto(findViewById<View>(R.id.ConsBlur) as ViewGroup)
//                    Blurry.with(this@HomeActivity)
//                        .radius(25)
//                        .sampling(4)
//                        .color(Color.argb(66, 255, 255, 0))
//                        .capture(binding.IvBlur)
//                        .getAsync {
//                            binding.IvBlur.setImageDrawable(
//                                BitmapDrawable(resources, it)
//                            )
//                        }

                    binding.ConsExpenseMembers.visibility = View.VISIBLE
                    binding.ConsMembers.visibility = View.GONE
                    binding.RvExpense.visibility = View.VISIBLE
                    binding.TvExpense.setBackgroundResource(R.drawable.bg_50)
                    binding.TvExpense.background.setColorFilter(
                        resources.getColor(R.color.white),
                        PorterDuff.Mode.SRC_ATOP
                    )
                    binding.TvMembers.setBackgroundResource(0)
                }
            })
        binding.TvExpense.setOnClickListener {
            binding.TvExpense.setBackgroundResource(R.drawable.bg_50)
            binding.TvExpense.background.setColorFilter(
                resources.getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP
            )
            binding.TvMembers.setBackgroundResource(0)
            binding.TvExpense.setTextColor(resources.getColor(R.color.main_color))
            binding.TvMembers.setTextColor(resources.getColor(R.color.white))
            binding.ConsMembers.visibility = View.GONE
            binding.RvExpense.visibility = View.VISIBLE
        }
        binding.TvMembers.setOnClickListener {
            binding.TvMembers.setBackgroundResource(R.drawable.bg_50)
            binding.TvMembers.background.setColorFilter(
                resources.getColor(R.color.white),
                PorterDuff.Mode.SRC_ATOP
            )
            binding.TvExpense.setBackgroundResource(0)
            binding.TvMembers.setTextColor(resources.getColor(R.color.main_color))
            binding.TvExpense.setTextColor(resources.getColor(R.color.white))
            binding.ConsMembers.visibility = View.VISIBLE
            binding.RvExpense.visibility = View.GONE
        }
        val adapter = ArrayAdapter(
            this@HomeActivity,
            android.R.layout.simple_spinner_item,
            arrayOf("Indian Rupee", "Pakistani Rupee")
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.LayoutAmount.SpinnerRupee.adapter = adapter
        binding.RvPersonData.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.RvPersonData.adapter = PersonDataAdapter(this@HomeActivity)
        binding.RvExpense.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.RvExpense.adapter =
            ExpenseAdapter(this@HomeActivity, object : ExpenseAdapter.ExpenseClick {
                override fun onExpenseClick() {
                    binding.ScrollAmountRupee.visibility = View.VISIBLE
                    binding.ConsExpenseMembers.visibility = View.GONE
                    binding.ConsHomeView.visibility = View.GONE
                    binding.ConsToolBar.visibility = View.GONE
                    binding.RvExpense.visibility = View.GONE
                    binding.ConsAddExpense.visibility = View.GONE
                    binding.ConsMembers.visibility = View.GONE
                    binding.ConsWithShape.visibility = View.VISIBLE
                    binding.ConsBlur.visibility = View.GONE
                    binding.ConsSetting.visibility = View.GONE
                }

                override fun onMenuClick() {
                    val dialog = Dialog(this@HomeActivity)
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                    dialog.setContentView(R.layout.dialog_menu)
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
            })

        val layoutInflater = applicationContext
            .getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView: View =
            layoutInflater.inflate(R.layout.dialog_popup, null)
        val popupWindow = PopupWindow(
            popupView,
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT
        )
        popupWindow.isTouchable = true
        binding.IvMenu.setOnClickListener {
            popupWindow.showAsDropDown(binding.IvMenu, -50, 10)
        }

        binding.ConsMain.setOnTouchListener { p0, p1 ->
            popupWindow.dismiss()
            false
        }
        binding.LayoutAmount.TvEditSplit.setOnClickListener {
            startActivity(Intent(this@HomeActivity, MemberListActivity::class.java))
        }



        binding.bottomMenu.setOnItemSelectedListener(object :
            ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.Menu_Home -> {
                        binding.ConsHomeView.visibility = View.VISIBLE
                        binding.ConsToolBar.visibility = View.VISIBLE
                        binding.ConsWithShape.visibility = View.GONE
                        binding.ConsAddExpense.visibility = View.GONE
                        binding.ConsBlur.visibility = View.GONE
                        binding.ConsSetting.visibility = View.GONE
                    }

                    R.id.MenuAddMember -> {
                        binding.ConsHomeView.visibility = View.GONE
                        binding.ConsToolBar.visibility = View.GONE
                        binding.ConsExpenseMembers.visibility = View.GONE
                        binding.ConsMembers.visibility = View.GONE
                        binding.RvExpense.visibility = View.GONE
                        binding.ScrollAmountRupee.visibility = View.GONE
                        binding.ConsWithShape.visibility = View.VISIBLE
                        binding.ConsAddExpense.visibility = View.VISIBLE
                        binding.ConsBlur.visibility = View.GONE
                        binding.ConsSetting.visibility = View.GONE
                    }

                    R.id.Menu_Settings -> {
                        binding.ConsHomeView.visibility = View.GONE
                        binding.ConsToolBar.visibility = View.GONE
                        binding.ConsWithShape.visibility = View.GONE
                        binding.ConsWithShape.visibility = View.GONE
                        binding.ConsAddExpense.visibility = View.GONE
                        binding.ConsBlur.visibility = View.GONE
                        binding.ConsSetting.visibility = View.VISIBLE
                    }
                }
            }

        })
        binding.bottomMenu.setItemSelected(R.id.Menu_Home, true)
        binding.ConsHomeView.visibility = View.VISIBLE
        binding.ConsToolBar.visibility = View.VISIBLE
        binding.ConsWithShape.visibility = View.GONE
        binding.ConsAddExpense.visibility = View.GONE
        binding.ConsBlur.visibility = View.GONE
        binding.ConsSetting.visibility = View.GONE
    }
}