package com.mintic.myaddressbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class CitiesAdapter(
    private val mCities: ArrayList<City>
) : RecyclerView.Adapter<CitiesAdapter.ViewHolder>() {

    val images = intArrayOf(
        R.drawable.pnn,
        R.drawable.chinchina,
        R.drawable.salamina,
        R.drawable.corredor,
        R.drawable.catedral,
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (city, excerpt, temp, image) = mCities[position]
        holder.title.text = city
        holder.excerpt.text = excerpt
        holder.temp.text = temp
        holder.image.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return mCities.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.item_title)
        var excerpt: TextView = itemView.findViewById(R.id.item_excerpt)
        var temp: TextView = itemView.findViewById(R.id.item_temp)
        var image: ImageView = itemView.findViewById(R.id.item_image)
    }
}
