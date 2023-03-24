package com.nibm.medicare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.models.Appointments
import com.nibm.medicare.R

class AppointmentsAdapter(private val doctorsList: ArrayList<Appointments>) : RecyclerView.Adapter<AppointmentsAdapter.AppointmentViewHolder>(){

    class AppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val specialization = itemView.findViewById<TextView>(R.id.txt_doc_speciality)
        val doctorName = itemView.findViewById<TextView>(R.id.txt_doc_name)
        val doctorMobile = itemView.findViewById<TextView>(R.id.txt_doc_mobile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.appointment_item, parent, false)
        return AppointmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val doctor = doctorsList[position]
        holder.specialization.text = doctor.dSpecialization
        holder.doctorName.text = doctor.dName
        holder.doctorMobile.text = doctor.dMobile
    }

    override fun getItemCount(): Int {
        return doctorsList.size
    }
}