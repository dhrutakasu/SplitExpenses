package com.example.splitexpense.ui.Activities

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.splitexpense.databinding.ActivitySelectLanguageBinding


class SelectLanguageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectLanguageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        initListeners()
        initActions()
    }

    private fun initViews() {

    }

    private fun initListeners() {
        binding.TvShowDashboard.setOnClickListener {
            startActivity(Intent(this@SelectLanguageActivity, HomeActivity::class.java))
        }
        binding.TvCreateNewGroup.setOnClickListener {
            startActivity(Intent(this@SelectLanguageActivity, CreateGroupActivity::class.java))
        }
        binding.TvImportGroup.setOnClickListener {
            startActivity(Intent(this@SelectLanguageActivity, ImportMemberActivity::class.java))
        }
    }

    private fun initActions() {
        binding.TvShowDashboard.paintFlags =
            binding.TvShowDashboard.paintFlags or Paint.UNDERLINE_TEXT_FLAG
    }
}