package com.lolozianas.amphibiansapp.ui.amphibian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.lolozianas.amphibiansapp.R
import com.lolozianas.amphibiansapp.databinding.FragmentAmphibianListBinding

/**
 * [AmphibianFragment] A fragment representing a list of Items.
 */
class AmphibianFragment : Fragment() {

    private var _binding: FragmentAmphibianListBinding? = null
    private val binding get() = _binding!!

    private val amphibianViewModel: AmphibianViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflates the layout with Data Binding
        _binding = FragmentAmphibianListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {

            // Allows Data Binding to observe LiveData with the lifecycle of this fragment
            lifecycleOwner = this@AmphibianFragment

            // Giving binding access to AmphibianViewModel
            viewModel = amphibianViewModel

            // Sets the Adapter of the amphibian RecyclerView
            recyclerViewAmphibian.adapter = AmphibianListAdapter(AmphibianListener { amphibian ->
                amphibianViewModel.onAmphibianClicked(amphibian)
                findNavController().navigate(R.id.action_amphibianFragment_to_amphibianDetailFragment)
            })

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}