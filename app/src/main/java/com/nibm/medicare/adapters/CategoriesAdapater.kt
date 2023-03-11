package com.nibm.medicare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.R
import com.nibm.medicare.models.Categories

class CategoriesAdapater(private val categoriesList: ArrayList<Categories>) : RecyclerView.Adapter<CategoriesAdapater.CategoriesViewHolder>(){
    class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage : ImageView = itemView.findViewById(R.id.category_img)
        val categoryTxt : TextView = itemView.findViewById(R.id.category_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category_item_grid, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categoriesList[position]
        holder.categoryImage.setImageResource(category.image)
        holder.categoryTxt.text = category.name
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }
}