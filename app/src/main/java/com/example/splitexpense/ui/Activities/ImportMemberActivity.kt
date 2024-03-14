package com.example.splitexpense.ui.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.splitexpense.R
import com.example.splitexpense.databinding.ActivityImportMemberBinding

class ImportMemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImportMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImportMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        initListeners()
        initActions()
    }

    private fun initViews() {

    }

    private fun initListeners() {
        binding.LayoutTool.TvRightView.setOnClickListener {
            startActivity(Intent(this@ImportMemberActivity, HomeActivity::class.java))
        }
        binding.LayoutTool.ConsLeft.setOnClickListener {
            finish()
        }
    }

    private fun initActions() {
        binding.LayoutTool.TvSubTitle.visibility = View.GONE
        binding.LayoutTool.TvGroup.text = getString(R.string.imports)
        binding.LayoutTool.TvRightView.text = getString(R.string.imports)
        binding.LayoutTool.TvSubTitle.text = getString(R.string.join_an_existing_group)
    }
}