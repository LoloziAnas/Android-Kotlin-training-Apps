package com.lolozianas.dogglersapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lolozianas.dogglersapp.adapter.DogCardAdapter
import com.lolozianas.dogglersapp.const.Layout
import com.lolozianas.dogglersapp.databinding.ActivityVerticalListBinding

class VerticalListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVerticalListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityVerticalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup adapter for the recycler view
        binding.rvVertical.adapter = DogCardAdapter(applicationContext, Layout.VERTICAL)

        // Specify fixed size to improve performance
        binding.rvVertical.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}