package com.example.splitexpense.ui.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.splitexpense.R
import com.example.splitexpense.databinding.ActivityEditSplitBinding
import com.example.splitexpense.databinding.ActivityMemberListBinding
import com.example.splitexpense.ui.Adapters.AmountPaidAdapter
import com.example.splitexpense.ui.Adapters.AmountPaidShareAdapter

class EditSplitActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditSplitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditSplitBinding.inflate(layoutInflater)
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
    }

    private fun initActions() {
        binding.RvShare.layoutManager = LinearLayoutManager(this@EditSplitActivity,
            RecyclerView.VERTICAL,false)
        binding.RvShare.adapter = AmountPaidShareAdapter(this@EditSplitActivity)
    }
}