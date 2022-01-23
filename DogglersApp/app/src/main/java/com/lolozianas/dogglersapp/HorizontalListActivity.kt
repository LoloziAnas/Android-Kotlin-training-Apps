package com.lolozianas.dogglersapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lolozianas.dogglersapp.adapter.DogCardAdapter
import com.lolozianas.dogglersapp.const.Layout
import com.lolozianas.dogglersapp.databinding.ActivityHorizontalListBinding

class HorizontalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHorizontalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHorizontalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup recycler view adapter
        binding.rvHorizontal.adapter = DogCardAdapter(applicationContext, Layout.HORIZONTAL)

        // Specify fixed size to improve performance
        binding.rvHorizontal.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}