package com.example.splitexpense

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.splitexpense.databinding.ActivityHomeBinding
import com.example.splitexpense.databinding.ActivityMainBinding
import jp.wasabeef.blurry.Blurry

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
        Blurry.with(applicationContext)
            .radius(10)
            .sampling(8)
            .color(Color.argb(66, 255, 255, 0))
            .async()
            .onto(binding.ConsBlurView)
    }
}