package com.nibm.medicare.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nibm.medicare.R
import com.nibm.medicare.models.QuickActionItem

class QuickActionsAdapter(var context: Context, var arrayList: ArrayList<QuickActionItem>) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return arrayList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View = View.inflate(context, R.layout.quick_actions_item_grid, null)
        var img : ImageView = view.findViewById(R.id.quick_action_img)
        var text : TextView = view.findViewById(R.id.quick_action_txt)

        var listItem : QuickActionItem = arrayList.get(position)
        img.setImageResource(listItem.img!!)
        text.setText(listItem.text)

        return view

    }
}