package com.example.myforecast.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myforecast.R
import com.example.myforecast.api.model.cities.Cities
import kotlinx.android.synthetic.main.city_card.view.*

interface OnItemClickCallback{
    fun onItemClick(name:String)
}

class CitiesAdapter(private val cities:List<Cities>, private val onItemClickCallback: OnItemClickCallback):RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        return CitiesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.city_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(cities[position], onItemClickCallback)
    }

    override fun getItemCount(): Int = cities.size

    class CitiesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(cities: Cities,onItemClickCallback: OnItemClickCallback){
            itemView.city_name_card.text = cities.name
            itemView.city_image_card.setImageResource(R.drawable.baseline_cloud)

            itemView.setOnClickListener {
                onItemClickCallback.onItemClick(
                    cities.name
                )
            }

        }
    }

}
