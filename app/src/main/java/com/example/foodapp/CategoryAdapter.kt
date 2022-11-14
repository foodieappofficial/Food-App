package com.example.foodapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class CategoryAdapter(private var foodList:ArrayList<Model>):
    RecyclerView.Adapter<CategoryAdapter.viewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
           val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_categories,parent,false)
           return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
          holder.foodImage.setImageResource(foodList[position].foodImage)
          holder.foodTitle.text = foodList[position].foodTitle

    }

    override fun getItemCount(): Int {
        return foodList.size
    }
    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodImage : ImageView = itemView.findViewById(R.id.food_image)
        val foodTitle : TextView = itemView.findViewById(R.id.food_title)
        val background :CardView = itemView.findViewById(R.id.cardView)
    }
}