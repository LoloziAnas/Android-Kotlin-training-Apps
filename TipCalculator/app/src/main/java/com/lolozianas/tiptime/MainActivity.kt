package com.lolozianas.tiptime

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.lolozianas.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    /**
     * let's say that you have 3 views in your xml layout and you need to access to them.
     * with using findViewById method you'll calling findViewById for each view in your layout.
     * and by using viewBiding feature you'll instantiate one binding object.
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // initialize the binding object for accessing to the views in the activity_main.xml layout.
        binding = ActivityMainBinding.inflate(layoutInflater)
        //  set the content view of the activity. instead of passing the Resource ID we'll just specifies
        // the root of the hierarchy of the views binding.root
        setContentView(binding.root)
        // calculate tip when the user clicks on calculate button
        binding.btnCalculate.setOnClickListener { calculateTip() }
        // hide the keyboard when the user click ENTER
        binding.editCostOfService.setOnKeyListener { view, keyCode, _ ->
            handleKeyEvent(
                view,
                keyCode
            )
        }
    }

    private fun calculateTip() {
        val stringInTextField = binding.textInputCostOfService.text.toString()
        val cost = stringInTextField.toDoubleOrNull()
        val tipPercentage = when (binding.rgTipOption.checkedRadioButtonId) {
            R.id.rb_amazing -> 0.20
            R.id.rb_good -> 0.18
            else -> 0.15
        }
        if (cost == null) {
            return
        }
        var tip = tipPercentage * cost
        if (binding.switchRoundUp.isChecked) {
            tip = ceil(tip)
        }

        displayTip(tip)
    }

    private fun displayTip(tip: Double) {
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tvTipAmount.text = getString(R.string.tip_amount, formattedTip)
    }

    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }


}