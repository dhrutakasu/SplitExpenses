package com.example.splitexpense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splitexpense.databinding.ActivityHomeBinding
import com.example.splitexpense.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
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