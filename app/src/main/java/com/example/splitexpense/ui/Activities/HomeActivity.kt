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
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitexpense.R
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
                    binding.ConsBlur.visibility = View.VISIBLE
//                    Blurry.with(this@HomeActivity)
//                        .radius(25)
//                        .sampling(2)
//                        .async()
//                        .animate(500)
//                        .onto(findViewById<View>(R.id.ConsBlur) as ViewGroup)
                    Blurry.with(this@HomeActivity)
                        .radius(25)
                        .sampling(4)
                        .color(Color.argb(66, 255, 255, 0))
                        .capture(binding.IvBlur)
                        .getAsync {
                            binding.IvBlur.setImageDrawable(
                                BitmapDrawable(resources, it)
                            )
                        }

                    binding.ConsExpenseMembers.visibility = View.VISIBLE
                    binding.ConsMembers.visibility = View.GONE
                    binding.RvExpense.visibility = View.VISIBLE
                    binding.TvExpense.setBackgroundResource(R.drawable.bg)
                    binding.TvExpense.background.setColorFilter(
                        resources.getColor(R.color.white),
                        PorterDuff.Mode.SRC_ATOP
                    )
                    binding.TvMembers.setBackgroundResource(0)
                }
            })
        binding.TvExpense.setOnClickListener {
            binding.TvExpense.setBackgroundResource(R.drawable.bg)
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
            binding.TvMembers.setBackgroundResource(R.drawable.bg)
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
                    binding.ConsWithShape.visibility = View.GONE
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


        binding.bottomMenu.setOnItemSelectedListener(object :
            ChipNavigationBar.OnItemSelectedListener {
            override fun onItemSelected(id: Int) {
                when (id) {
                    R.id.MenuAddMember -> {
                        Handler().postDelayed({
                            startActivity(Intent(this@HomeActivity, MemberListActivity::class.java))
                        }, 2000)
                    }

                    R.id.Menu_Settings -> {
                        binding.ConsHomeView.visibility = View.GONE
                        binding.ConsToolBar.visibility = View.GONE
                        binding.ConsWithShape.visibility = View.GONE
                        binding.ConsWithShape.visibility = View.GONE
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
        binding.ConsWithShape.visibility = View.GONE
        binding.ConsBlur.visibility = View.GONE
        binding.ConsSetting.visibility = View.GONE
    }
}