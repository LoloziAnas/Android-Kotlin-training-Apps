package com.lolozianas.dogglersapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lolozianas.dogglersapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // instantiate binding object of main activity
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setup view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // launch the HorizontalListActivity on btnHorizontal click
        binding.btnHorizontal.setOnClickListener {
            startActivity(Intent(this, HorizontalListActivity::class.java))
        }

        // launch the VerticalListActivity on btnVertical click
        binding.btnVertical.setOnClickListener {
            startActivity(Intent(this, VerticalListActivity::class.java))
        }

        // launch the GridListActivity when the user click on grid button
        binding.btnGrid.setOnClickListener {
            startActivity(Intent(this, GridListActivity::class.java))
        }
    }
}