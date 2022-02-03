package com.lolozianas.unscrambleapp.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lolozianas.unscrambleapp.R
import com.lolozianas.unscrambleapp.databinding.GameFragmentBinding

/** [GameFragment] a fragment contain the game logic*/
class GameFragment : Fragment() {


    // Binding object instance with access to the views in the game_fragment.xml layout
    private lateinit var binding: GameFragmentBinding

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the XML file and return a binding object instance
        binding = GameFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Set the viewModel for data binding - this allows the bound layout access
        // to all the data in the VieWModel
        binding.gameViewModel = viewModel
        binding.maxNoOfWords = MAX_NO_OF_WORDS
        // Specify the fragment view as the lifecycle owner of the binding.
        // This is used so that the binding can observe LiveData updates
        binding.lifecycleOwner = viewLifecycleOwner
        // Setup a listeners click for skip and submit buttons
        binding.buttonSkip.setOnClickListener { onSkipWord() }
        binding.buttonSubmit.setOnClickListener { onSubmitWord() }
    }

    private fun onSubmitWord() {
        val playerWord = binding.inputEditTextWord.text?.trim().toString()
        if (viewModel.isUserCurrentWord(playerWord)) {
            setErrorTextField(false)
            binding.inputEditTextWord.text?.clear()
            if (!viewModel.nextWord()) {
                showFinalScoreDialog()
            }
        } else {
            setErrorTextField(true)
        }

    }

    /* Create and show a dialog alert with the final score*/
    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            // Set the alert dialog's title
            .setTitle(getString(R.string.congratulations))
            // Set message that containing the final score of the player
            .setMessage(getString(R.string.you_scored, viewModel.score.value))
            .setCancelable(false)
            // Restart the game of the player click on the positive button
            .setPositiveButton(getString(R.string.play_again)) { _, _ -> restartGame() }
            // Exits the game of the player clicks on the negative button
            .setNegativeButton(getString(R.string.exit)) { _, _ -> exitGame() }
            // Show the dialog
            .show()
    }

    /* Exits the game */
    private fun exitGame() {
        activity?.finish()
    }
    /*
     * Re-initializes the data in the ViewModel and updates the views with the new data, to
     * restart the game.
     */

    private fun restartGame() {
        viewModel.reinitializeData()
        setErrorTextField(false)
    }

    /*
    * Skips the current word without changing the score.
    * Increases the word count.
    * After the last word, the user is shown a Dialog with the final score.
    */
    private fun onSkipWord() {
        if (viewModel.nextWord()) {
            setErrorTextField(false)
        } else {
            showFinalScoreDialog()
        }
    }

    /*
      * Sets and resets the text field error status.
      */
    private fun setErrorTextField(error: Boolean) {
        if (error) {
            binding.inputLayout.isErrorEnabled = true
            binding.inputLayout.error = getString(R.string.try_again)
        } else {
            binding.inputLayout.isErrorEnabled = false
            binding.inputLayout.error = null
        }
    }


}