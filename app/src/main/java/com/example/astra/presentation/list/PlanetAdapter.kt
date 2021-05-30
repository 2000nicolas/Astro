package com.example.astra.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.astra.R

class PlanetAdapter(private var dataSet: List<Planet>, val listener: ((Planet) -> Unit)? = null) : RecyclerView.Adapter<PlanetAdapter.ViewHolder>() {


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageView: ImageView

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.planet_name)
            imageView=view.findViewById(R.id.imgrdm)
        }

    }

    fun updateList(list: List<Planet>){
        dataSet = list
        notifyDataSetChanged()
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.country_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        val planet = dataSet[position]
        viewHolder.textView.text = planet.name
        viewHolder.itemView.setOnClickListener {
            listener?.invoke(planet)
        }

        Glide
            .with(viewHolder.itemView.context)
            .load("https://media.istockphoto.com/photos/night-scenery-with-colorful-and-light-yellow-milky-way-full-of-stars-picture-id1144084096?k=6&m=1144084096&s=612x612&w=0&h=d-Cu_4ls6WJ8bQOoHdKSw7rz0H--dH0TshaXBZH_Wak=")
            .centerCrop()
            .into(viewHolder.imageView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}

