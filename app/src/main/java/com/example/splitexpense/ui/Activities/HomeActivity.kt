package com.example.splitexpense.ui.Activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitexpense.R
import com.example.splitexpense.databinding.ActivityHomeBinding
import com.example.splitexpense.ui.Adapters.ExpenseAdapter
import com.example.splitexpense.ui.Adapters.ListFolderAddAdapter
import com.example.splitexpense.ui.Adapters.MemberAddAdapter
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
        binding.RvListAndFolder.adapter = ListFolderAddAdapter(this@HomeActivity)
        binding.RvPersonData.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.RvPersonData.adapter = ListFolderAddAdapter(this@HomeActivity)
        binding.RvExpense.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.RvExpense.adapter = ExpenseAdapter(this@HomeActivity)
        binding.bottomMenu.setItemSelected(R.id.Menu_Home, true)
    }
}