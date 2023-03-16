package com.nibm.medicare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.models.Appointments
import com.nibm.medicare.R

class AppointmentsAdapter(private val appointmentList: ArrayList<Appointments>) : RecyclerView.Adapter<AppointmentsAdapter.AppointmentViewHolder>(){
    class AppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val appointmentDate : TextView = itemView.findViewById(R.id.txt_appointment_date)
        val nameType : TextView = itemView.findViewById(R.id.txt_name_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.appointment_item, parent, false)
        return AppointmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val appointment = appointmentList[position]
        holder.appointmentDate.text = appointment.date
        holder.nameType.text = appointment.name
    }

    override fun getItemCount(): Int {
        return appointmentList.size
    }
}