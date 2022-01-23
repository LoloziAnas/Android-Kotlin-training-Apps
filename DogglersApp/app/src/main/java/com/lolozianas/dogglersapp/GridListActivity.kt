package com.lolozianas.dogglersapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lolozianas.dogglersapp.adapter.DogCardAdapter
import com.lolozianas.dogglersapp.const.Layout
import com.lolozianas.dogglersapp.databinding.ActivityGridListBinding

class GridListActivity : AppCompatActivity() {

    // create a binding object for the grid list activity
    private lateinit var binding: ActivityGridListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // inflate the layout
        binding = ActivityGridListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding the recycler view
        binding.rvGrid.adapter = DogCardAdapter(applicationContext, Layout.GRID)

        // enable fixed size for the recycler view for better performance
        binding.rvGrid.setHasFixedSize(true)
        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}