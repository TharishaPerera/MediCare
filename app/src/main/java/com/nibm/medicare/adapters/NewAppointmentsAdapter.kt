package com.nibm.medicare.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.R
import com.nibm.medicare.models.NewAppointments

class NewAppointmentsAdapter(private val newAppointmentsList: ArrayList<NewAppointments>) : RecyclerView.Adapter<NewAppointmentsAdapter.NewAppointmentViewHolder>() {

    var onItemClick : ((NewAppointments) -> Unit)? = null

    class NewAppointmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val specialization = itemView.findViewById<TextView>(R.id.txt_doc_speciality)
        val doctorName = itemView.findViewById<TextView>(R.id.txt_doc_name)
        val doctorMobile = itemView.findViewById<TextView>(R.id.txt_doc_mobile)
        val doctorEmail = itemView.findViewById<TextView>(R.id.txt_doc_email)
        val doctorAddress = itemView.findViewById<TextView>(R.id.txt_doc_address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAppointmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_appointment_item, parent, false)
        return NewAppointmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewAppointmentViewHolder, position: Int) {
        val newAppointment = newAppointmentsList[position]
        //holder.doctorImage.setImageResource(newAppointment.image)
        holder.doctorName.text = newAppointment.dName
        holder.specialization.text = newAppointment.dSpecialization
//        holder.doctorMobile.text = newAppointment.dMobile
//        holder.doctorEmail.text = newAppointment.dEmail
        holder.doctorAddress.text = newAppointment.dAddress

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(newAppointment)
        }
    }

    override fun getItemCount(): Int {
        return newAppointmentsList.size
    }
}