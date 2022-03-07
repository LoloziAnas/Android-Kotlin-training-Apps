package com.lolozianas.amphibiansapp.ui.amphibian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.lolozianas.amphibiansapp.databinding.FragmentAmphibianDetailBinding

/**
 * [AmphibianDetailFragment] shows the detailed information about particular amphibian.
 */
class AmphibianDetailFragment : Fragment() {

    // Initialize the Amphibian ViewModel
    private val amphibianViewModel: AmphibianViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentAmphibianDetailBinding.inflate(layoutInflater)
        // Assign the view model
        binding.viewModel = amphibianViewModel
        // Define the lifecycle owner as the the lifecycle of the fragment.
        binding.lifecycleOwner = this

        return binding.root
    }


}