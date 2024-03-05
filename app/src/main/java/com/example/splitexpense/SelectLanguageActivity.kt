package com.example.splitexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splitexpense.databinding.ActivitySelectLanguageBinding

class SelectLanguageActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectLanguageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectLanguageBinding.inflate(layoutInflater)
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

    }
}