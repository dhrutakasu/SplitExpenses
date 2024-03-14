package com.example.splitexpense.ui.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.splitexpense.R
import com.example.splitexpense.databinding.ActivityCreateGroupBinding
import com.example.splitexpense.ui.Adapters.MemberAddAdapter

class CreateGroupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGroupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initListeners()
        initActions()
    }

    private fun initViews() {

    }

    private fun initListeners() {
        binding.LayoutTool.ConsLeft.setOnClickListener {
            finish()
        }
        binding.LayoutTool.TvRightView.setOnClickListener {
            startActivity(Intent(this@CreateGroupActivity, HomeActivity::class.java))
        }
    }

    private fun initActions() {
        binding.LayoutTool.TvSubTitle.visibility = View.GONE
        binding.LayoutTool.TvGroup.text = getString(R.string.create_group)

        binding.RvMembers.layoutManager = LinearLayoutManager(this@CreateGroupActivity)
        binding.RvMembers.adapter = MemberAddAdapter(this@CreateGroupActivity)
    }
}