package com.lolozianas.wordsapp

import android.os.Bundle
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
class LetterListFragment : Fragment() {

    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!
    private lateinit var letterRecyclerView: RecyclerView
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Display the option menu on the fragment
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        letterRecyclerView = binding.recyclerView
        chooseLayout()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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