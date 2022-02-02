package com.lolozianas.unscrambleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.lolozianas.unscrambleapp.databinding.ActivityMainBinding

/** Architecture provides you with the guidelines to help you allocate responsibilities in your app
 * between the classes.
 * A well-designed app architecture helps you scale you app and extend it with  additional features
 * in the future
 * */
/** Create an activity that host the Game fragment in the app*/
class MainActivity : AppCompatActivity() {

    // Create navigation controller object
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Retrieve the binding object
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Gets the nav host fragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Sets the Navigation Controller
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}