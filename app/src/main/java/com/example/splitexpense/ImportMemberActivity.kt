package com.example.splitexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.splitexpense.databinding.ActivityImportMemberBinding
import com.example.splitexpense.databinding.ActivityMainBinding

class ImportMemberActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImportMemberBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityImportMemberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initListerens()
        initActions()
    }

    private fun initViews() {

    }

    private fun initListerens() {

    }

    private fun initActions() {

        binding.LayoutTool.TvSubTitle.visibility = View.GONE
        binding.LayoutTool.TvGroup.text = getString(R.string.imports)
        binding.LayoutTool.TvRightView.text = getString(R.string.imports)
        binding.LayoutTool.TvSubTitle.text = getString(R.string.join_an_existing_group)
    }
}