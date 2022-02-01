package com.lolozianas.wordsapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.wordsapp.adapter.LetterAdapter
import com.lolozianas.wordsapp.databinding.FragmentLetterListBinding

/**
 * A simple [Fragment] subclass.
 * create an instance of this fragment.
 */

const val TAG = "LetterListFragment"
class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!
    private lateinit var letterRecyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Called")
        // Display the option menu on the fragment
        setHasOptionsMenu(true)
        
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView: Called")
        // Inflate the layout for this fragment
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: Called")
        letterRecyclerView = binding.recyclerView
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestroyView: Called")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(TAG, "onDetach: Called")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach: Called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Called")
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Inflate the R.menu.menu_layout on option menu
        inflater.inflate(R.menu.menu_layout, menu)
        // Find the menu item switch layout
        val itemView = menu.findItem(R.id.action_switch_layout)
        setIcon(itemView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            // Sets the LinearLayoutManager of the recyclerview
            letterRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        } else {
            // Sets the GridLayoutManager with span count = 4 of the recyclerview
            letterRecyclerView.layoutManager = GridLayoutManager(requireContext(), 4)
        }
        // Sets the adapter of the recyclerView
        letterRecyclerView.adapter = LetterAdapter()
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null) {
            return
        }
        // Set the drawable for the menu icon based on which LayoutManager is currently in use
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_linear)
            else
                ContextCompat.getDrawable(requireContext(), R.drawable.ic_grid)

    }

}