package com.example.splitexpense.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
        binding.RvMemberList.adapter = MemberListAdapter(this@MemberListActivity)
    }
}