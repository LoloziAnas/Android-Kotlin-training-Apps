package com.lolozianas.wordsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.wordsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve a binding object that allows to refer to views by id name
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}