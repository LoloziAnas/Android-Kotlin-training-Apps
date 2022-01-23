package com.lolozianas.dogglersapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lolozianas.dogglersapp.R
import com.lolozianas.dogglersapp.const.Layout
import com.lolozianas.dogglersapp.data.DataSource

class DogCardAdapter(private val context: Context?, private val layout: Int) :
    RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {
    private val dogs = DataSource.dogs
    private lateinit var view: View

    class DogCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val dogPicture: ImageView = view.findViewById(R.id.iv_dog_pic)
        val dogName: TextView = view.findViewById(R.id.tv_dog_name)
        val dogAge: TextView = view.findViewById(R.id.tv_dog_age)
        val dogHobbies: TextView = view.findViewById(R.id.tv_dog_hobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {

        // Use a conditional to determine the layout type and set it accordingly.
        // if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        // the vertical/horizontal list item should be used.
        val inflater = LayoutInflater.from(parent.context)

        // inflating layouts
        when (layout) {
            Layout.GRID -> view = inflater.inflate(R.layout.grid_list_item, parent, false)
            Layout.HORIZONTAL, Layout.VERTICAL -> view = inflater.inflate(
                R.layout.horizontal_vertical_list_item,
                parent,
                false
            )
        }
        // return the view holder
        return DogCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // Get the data at the current position
        val dog = dogs[position]
        // Set the image resource for the current dog
        holder.dogPicture.setImageResource(dog.imageResId)
        // Set the text for the current dog's name
        holder.dogName.text = dog.name
        // instantiate a resources object
        val resources = context?.resources
        // Set the text for the current dog's age
        holder.dogAge.text = resources?.getString(R.string.doge_age, dog.age)
        // Set the text for the current dog's hobbies by passing the hobbies to the
        holder.dogHobbies.text = resources?.getString(R.string.doge_hobbies, dog.hobbies)

    }

    override fun getItemCount() = dogs.size

}