package com.nibm.medicare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.R
import com.nibm.medicare.models.MedicalRecords

class MedicalRecordsAdapter(private val recordsList: ArrayList<MedicalRecords>): RecyclerView.Adapter<MedicalRecordsAdapter.RecordsViewHolder>() {
    class RecordsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val recordDate : TextView = itemView.findViewById(R.id.txt_record_date)
        val nameType : TextView = itemView.findViewById(R.id.txt_record_name_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.medical_record_item, parent, false)
        return RecordsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecordsViewHolder, position: Int) {
        val record = recordsList[position]
        holder.recordDate.text = record.date
        holder.nameType.text = record.name
    }

    override fun getItemCount(): Int {
        return recordsList.size
    }
}