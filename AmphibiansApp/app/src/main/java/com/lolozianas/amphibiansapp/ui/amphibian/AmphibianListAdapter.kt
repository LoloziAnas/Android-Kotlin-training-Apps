package com.lolozianas.amphibiansapp.ui.amphibian

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.amphibiansapp.databinding.ListViewAmphibianBinding
import com.lolozianas.amphibiansapp.network.Amphibian

class AmphibianListAdapter :
    ListAdapter<Amphibian, AmphibianListAdapter.AmphibianViewHolder>(DiffCallback) {

    inner class AmphibianViewHolder(private var binding: ListViewAmphibianBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(amphibian: Amphibian) {
            binding.amphibianName.text = amphibian.name
        }
    }

    /**
     * Allows [RecyclerView] to determine which items have changed when the [List] of [Amphibian]
     * has been updated
     * */
    companion object DiffCallback : DiffUtil.ItemCallback<Amphibian>() {
        override fun areItemsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Amphibian, newItem: Amphibian): Boolean {
            return oldItem.description == newItem.description
        }

    }

    /**
     * Create new [RecyclerView] item views (invoked by LayoutManager)
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmphibianViewHolder {
        return AmphibianViewHolder(ListViewAmphibianBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the content of a view (invoked by layout manager)
     * */
    override fun onBindViewHolder(holder: AmphibianViewHolder, position: Int) {
        val amphibian = getItem(position)
        holder.bind(amphibian)
    }

    class AmphibianListener(val clickListener: (amphibian: Amphibian) -> Unit) {
        fun onClick(amphibian: Amphibian) = clickListener(amphibian)
    }
}