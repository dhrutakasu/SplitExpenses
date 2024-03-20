package com.example.splitexpense.ui.Activities

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.Constants.Const
import com.example.splitexpense.R
import com.example.splitexpense.Utils.LoadProgressDialog
import com.example.splitexpense.Utils.utilsJava.FloatingActionMenu
import com.example.splitexpense.databinding.ActivityHomeBinding
import com.example.splitexpense.retrofit.RetrofitConfig
import com.example.splitexpense.ui.Adapters.AmountPaidAdapter
import com.example.splitexpense.ui.Adapters.ExpenseAdapter
import com.example.splitexpense.ui.Adapters.ListFolderAddAdapter
import com.example.splitexpense.ui.Adapters.PersonDataAdapter
import com.ismaeldivita.chipnavigation.ChipNavigationBar
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeActivity : AppCompatActivity() {
    private lateinit var context: HomeActivity
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
        context=this@HomeActivity
    }

    private fun initListeners() {

    }

    private fun initActions() {
        binding.IvBackHome.setOnClickListener {
            binding.ConsHomeView.visibility = View.VISIBLE
            binding.ConsToolBar.visibility = View.VISIBLE
            binding.ConsWithShape.visibility = View.GONE
            binding.ConsAddExpense.visibility = View.GONE
            binding.ConsBlur.visibility = View.GONE
            binding.ConsSetting.visibility = View.GONE
        }
        binding.LayoutSetting.ConsLeft.setOnClickListener {
            binding.ConsHomeView.visibility = View.VISIBLE
            binding.ConsToolBar.visibility = View.VISIBLE
            binding.ConsWithShape.visibility = View.GONE
            binding.ConsAddExpense.visibility = View.GONE
            binding.ConsBlur.visibility = View.GONE
            binding.ConsSetting.visibility = View.GONE
        }
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

                override fun onShareClick() {
                    startActivity(Intent(this@HomeActivity, ShareActivity::class.java))
                }
            })
        binding.FloatingFab.setOnFloatingActionsMenuUpdateListener(object :
            FloatingActionMenu.OnFloatingActionsMenuUpdateListener {
            override fun onMenuExpanded() {
                binding.Blurrys.visibility = View.VISIBLE
                binding.ConsMain.isClickable = false
            }

            override fun onMenuCollapsed() {
                binding.Blurrys.visibility = View.GONE
                binding.ConsMain.isClickable = true

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


        binding.LayoutAmount.RvAmountDataList.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.LayoutAmount.RvAmountDataList.adapter = AmountPaidAdapter(this@HomeActivity)


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

                    binding.LayoutAmount.RvAmountDataList.layoutManager = LinearLayoutManager(this@HomeActivity,RecyclerView.HORIZONTAL,false)
                    binding.LayoutAmount.RvAmountDataList.adapter = AmountPaidAdapter(this@HomeActivity)
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
                    val IvCancel = dialog.findViewById<ImageView>(R.id.IvCancel)
                    IvCancel.setOnClickListener {
                        dialog.dismiss()
                    }

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
        val TvEditGroup = popupView.findViewById<TextView>(R.id.TvEditGroup)
        TvEditGroup.setOnClickListener {
            popupWindow.dismiss()
            startActivity(Intent(this@HomeActivity, CreateGroupActivity::class.java))
        }
        binding.IvMenu.setOnClickListener {
            popupWindow.showAsDropDown(binding.IvMenu, -50, 10)
        }

        binding.ConsMain.setOnTouchListener { p0, p1 ->
            popupWindow.dismiss()
            false
        }
        binding.LayoutAmount.TvEditSplit.setOnClickListener {
            startActivity(Intent(this@HomeActivity, EditSplitActivity::class.java))
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

        initApis()
    }

    private fun initApis() {
        if (Const.isNetwork(applicationContext)) {
            LoadProgressDialog.showDialog(context)
            val call = RetrofitConfig.getRequestInterface().forgotPassword(
                    ""
                )

            call.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    when (response.code()) {
                        200 -> {

                        }

                        401 -> {

                        }

                        else -> {
                            LoadProgressDialog.hideDialog(context)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    LoadProgressDialog.hideDialog(context)
                }
            })
        } else {
            Const.showNoInternetDialog(context, object : Const.Companion.TryAgainInternet {
                override fun InternetAgainClick() {
                   initApis()
                }
            })
        }
    }
}