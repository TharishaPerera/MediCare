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
        val doctorImage: ImageView = itemView.findViewById(R.id.img_doc_image)
        val doctorName: TextView = itemView.findViewById(R.id.txt_doc_name)
        val doctorlocation: TextView = itemView.findViewById(R.id.txt_doc_location)
        val doctorSpeciality: TextView = itemView.findViewById(R.id.txt_doc_speciality)
        val doctorRating: TextView = itemView.findViewById(R.id.txt_doc_rating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewAppointmentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_appointment_item, parent, false)
        return NewAppointmentViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewAppointmentViewHolder, position: Int) {
        val newAppointment = newAppointmentsList[position]
        holder.doctorImage.setImageResource(newAppointment.image)
        holder.doctorName.text = newAppointment.name
        holder.doctorSpeciality.text = newAppointment.speciality
        holder.doctorlocation.text = newAppointment.location
        holder.doctorRating.text = newAppointment.rating

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(newAppointment)
        }
    }

    override fun getItemCount(): Int {
        return newAppointmentsList.size
    }
}