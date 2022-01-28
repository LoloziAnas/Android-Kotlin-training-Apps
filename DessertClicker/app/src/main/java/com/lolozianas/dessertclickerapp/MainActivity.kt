package com.lolozianas.dessertclickerapp

import android.content.ActivityNotFoundException
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.databinding.DataBindingUtil
import com.lolozianas.dessertclickerapp.data.DataSource
import com.lolozianas.dessertclickerapp.databinding.ActivityMainBinding

// tag for logging
const val TAG = "MainActivity"

// onSaveInstanceState Bundle Keys
const val KEY_REVENUE = "revenue_key"
const val KEY_DESSERT_SOLD = "dessert_sold_key"

class MainActivity : AppCompatActivity() {


    // Contains all the views
    private lateinit var binding: ActivityMainBinding
    private var revenue = 0
    private var dessertsSold = 0

    private var currentDessert = DataSource.allDesserts[0]
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Called")

        // Use data binding to get references to the views
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.imgBtnDessert.setOnClickListener { onDessertClicked() }
        // If there is a savedInstanceState bundle, then you're "restarting" the activity
        // If there isn't a bundle, then it's a "fresh" start
        if (savedInstanceState != null) {
            revenue = savedInstanceState.getInt(KEY_REVENUE)
            dessertsSold = savedInstanceState.getInt(KEY_DESSERT_SOLD)
            // Show the correct dessert
            showCurrentDessert()
        }

        // Make sure the correct dessert is showing
        binding.imgBtnDessert.setImageResource(currentDessert.imageId)

        // Set the TextViews to the right values
        binding.revenue = revenue
        binding.amountSold = dessertsSold
    }

    private fun onDessertClicked() {
        // Update the score
        revenue += currentDessert.price
        dessertsSold++
        // Display the values after the update
        binding.revenue = revenue
        binding.amountSold = dessertsSold
        // Show the next dessert
        showCurrentDessert()
    }

    /**
     * Determine which dessert to show.
     */
    private fun showCurrentDessert() {
        var newDessert = DataSource.allDesserts[0]
        for (dessert in DataSource.allDesserts) {
            if (dessertsSold >= dessert.startProductionAmount) {
                newDessert = dessert
            }
            // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
            // you'll start producing more expensive desserts as determined by startProductionAmount
            // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
            // than the amount sold.
            else break
        }

        // If the new dessert is actually different than the current dessert, update the image
        if (newDessert != currentDessert) {
            currentDessert = newDessert
            binding.imgBtnDessert.setImageResource(newDessert.imageId)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Called")
    }


    /**
     *
     * */
    private fun onShare() {
        // ShareCompat is an extra helper for sharing data between activities.
        // and also provides functionality to extend from ACTION_SEND / ACTION_SEND_MULTIPLE protocol
        val shareIntent = ShareCompat
            // IntentBuilder provides helper functions for constructing a sharing intent.
            .IntentBuilder(this)
            .setText(getString(R.string.share_text, dessertsSold, revenue))
            .setType("text/plain")
            .intent
        try {
            startActivity(shareIntent)
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(
                this, getString(R.string.sharing_not_available),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.d(TAG, "onSaveInstanceState: Called")
        outState.putString(KEY_REVENUE, revenue.toString())
        outState.putString(KEY_DESSERT_SOLD, dessertsSold.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.shareMenuButton -> onShare()
        }
        return super.onOptionsItemSelected(item)
    }
}