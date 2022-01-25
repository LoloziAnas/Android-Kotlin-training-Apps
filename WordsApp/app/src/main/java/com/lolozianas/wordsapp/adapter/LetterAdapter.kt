package com.lolozianas.wordsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.wordsapp.DetailsActivity
import com.lolozianas.wordsapp.R

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    // Generates a [CharRange] from 'A' to 'Z' and converts it to a list
    private val alphabets = ('A').rangeTo('Z').toList()

    /** Provides a reference of the views needed to display items in your list */
    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }

    /** Creates new view with R.layout.item_view as a template */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view, parent, false)
        return LetterViewHolder(adapterLayout)
    }

    /** Replace the content of an existing view with the new data */
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val alphabet = alphabets[position]
        holder.button.text = alphabet.toString()
        val context = holder.view.context
        holder.button.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity.LETTER, holder.button.text)
            context.startActivity(intent)
        }
    }

    /** Gets the number of items that will be displayed */
    override fun getItemCount(): Int = alphabets.size
}