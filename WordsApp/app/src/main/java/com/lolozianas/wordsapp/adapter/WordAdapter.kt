package com.lolozianas.wordsapp.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.wordsapp.R
import com.lolozianas.wordsapp.WordListFragment

class WordAdapter(private val letter: String, context: Context) :
    RecyclerView.Adapter<WordAdapter.WordViewHolder>() {
    private val filteredWords: List<String>

    init {
        // Retrieve the list of words from res/values/arrays.xml
        val words = context.resources.getStringArray(R.array.words).toList()
        filteredWords = words
            // Returns items in a collection if the conditional clause is true,
            // in this case if an item starts with the given letter,
            // ignoring UPPERCASE or lowercase.
            .filter { it.startsWith(letter, ignoreCase = true) }
            // Returns a collection that has shuffled in place
            .shuffled()
            // Returns the first 5 words as a list
            .take(5)
            // Returns a sorted version of the list
            .sorted()
    }

    class WordViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button: Button = view.findViewById(R.id.button_item)
    }
    /**
     * Creates new views with R.layout.item_view as its template
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return WordViewHolder(layout)
    }
    /**
     * Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val word = filteredWords[position]
        // context instance need to call startActivity
        val context = holder.view.context
        // Set the text of the WordViewHolder
        holder.button.text = word
        //
        holder.button.setOnClickListener {
            val queryUrl = Uri.parse("${WordListFragment.SEARCH_PREFIX}$word")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = filteredWords.size

}