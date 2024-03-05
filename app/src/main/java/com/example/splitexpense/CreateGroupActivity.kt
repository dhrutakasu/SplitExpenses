package com.example.splitexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.splitexpense.databinding.ActivityCreateGroupBinding
import com.example.splitexpense.databinding.ActivityMainBinding

class CreateGroupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGroupBinding.inflate(layoutInflater)
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
        binding.LayoutTool.TvGroup.text = getString(R.string.create_group)
    }
}