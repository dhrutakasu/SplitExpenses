package com.example.splitexpense.ui.Activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.splitexpense.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
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
        startActivity(Intent(this@SplashActivity, SelectLanguageActivity::class.java))
    }
}