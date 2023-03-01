package com.nibm.medicare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.R
import com.nibm.medicare.models.QuickActionItem

class QuickActionItemAdapter(private val quickActionList:ArrayList<QuickActionItem>) : RecyclerView.Adapter<QuickActionItemAdapter.QuickActionItemViewHolder>() {
    class QuickActionItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val quickActionImg : ImageView = itemView.findViewById(R.id.quick_action_img)
        val quickActionTxt : TextView = itemView.findViewById(R.id.quick_action_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuickActionItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quick_actions_item_grid, parent, false)
        return QuickActionItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuickActionItemViewHolder, position: Int) {
        val quickActionItem = quickActionList[position]
        holder.quickActionImg.setImageResource(quickActionItem.image)
        holder.quickActionTxt.text = quickActionItem.name
    }

    override fun getItemCount(): Int {
        return quickActionList.size
    }

}