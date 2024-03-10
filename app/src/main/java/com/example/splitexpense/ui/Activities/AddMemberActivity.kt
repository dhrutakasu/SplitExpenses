package com.example.splitexpense.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.splitexpense.R
import com.example.splitexpense.databinding.ActivityAddMemberBinding

class AddMemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMemberBinding.inflate(layoutInflater)
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
        binding.LayoutTool.TvSubTitle.visibility = View.VISIBLE
        binding.LayoutTool.TvGroup.text = getString(R.string.members)
        binding.LayoutTool.TvSubTitle.text = getString(R.string.manage_group_members)
    }
}