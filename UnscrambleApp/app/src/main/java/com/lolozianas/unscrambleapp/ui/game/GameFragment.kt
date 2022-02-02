package com.lolozianas.unscrambleapp.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lolozianas.unscrambleapp.databinding.GameFragmentBinding

/** [GameFragment] a fragment contain the game logic*/
class GameFragment : Fragment() {


    // Binding object instance with access to the views in the game_fragment.xml layout
    private lateinit var binding: GameFragmentBinding

    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the XML file and return a binding object instance
        binding = GameFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Setup a listeners click for skip and submit buttons
        binding.buttonSkip.setOnClickListener { onSkipWord() }
        binding.buttonSubmit.setOnClickListener { onSubmitWord() }
    }

    private fun onSubmitWord() {
        TODO("Not yet implemented")
    }

    private fun onSkipWord() {
        TODO("Not yet implemented")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

}