package com.recyclerviewapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R

import kotlinx.android.synthetic.main.recom_item_custom_row.view.*

class RecomItemAdapter(val context: Context, val items: ArrayList<String>) :
    RecyclerView.Adapter<RecomItemAdapter.ViewHolder>() {

    /**
     * Inflates the item views which is designed in xml layout file
     *
     * create a new
     * {@link ViewHolder} and initializes some private fields to be used by RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.recom_item_custom_row,
                parent,
                false
            )
        )
    }

    /**
     * Binds each item in the ArrayList to a view
     *
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     */
    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = items.get(position)

        holder.tvItem.text = item

         //Updating the background color randomly in list.
            holder.cardViewItem.setCardBackgroundColor(
                ContextCompat.getColor(
                    context,
                    colorChooser()
                )
            )

        //holder.cardViewItem.radius = 150.0f

    }


    private fun colorChooser(): Int{

        val colors = ArrayList<Int>()
        colors.add(R.color.brown_bg)
        colors.add(R.color.purple_bg)
        colors.add(R.color.green_bg)
        colors.add(R.color.yellow_bg)

        val bgColor = colors.random()
        return bgColor

    }


    /**
     * Gets the number of items in the list
     */
    override fun getItemCount(): Int {
        return items.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        val tvItem = view.tv_recom_item_name
        val cardViewItem = view.card_view_item
    }
}