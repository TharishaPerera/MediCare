package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.nibm.medicare.models.NewAppointments

class DoctorDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)

        val doctor = intent.getParcelableExtra<NewAppointments>("doctor")
        if(doctor != null){
            var doctorImage : ImageView = findViewById(R.id.img_doc_profile)
            var doctorName : TextView = findViewById(R.id.txt_doc_name)
            var speciality : TextView = findViewById(R.id.txt_doc_speciality)
            var location : TextView = findViewById(R.id.txt_doc_location)
            var rating : TextView = findViewById(R.id.txt_doc_rating)
            var appointmentDate : TextView = findViewById(R.id.txt_appointment_available_date)
            var hospital1 : TextView = findViewById(R.id.txt_hospital_1)
            var time1 : TextView = findViewById(R.id.txt_time_1)

            doctorImage.setImageResource(doctor.image)
            doctorName.text = doctor.name
            speciality.text = doctor.speciality
            location.text = doctor.location
            rating.text = doctor.rating
            appointmentDate.text = doctor.date
            hospital1.text = doctor.hospital1
            time1.text = doctor.time1
        }

        handleNavigation()
    }

    private fun handleNavigation() {
        var btnDashboard: ImageView
        var btnAppointments: ImageView
        var btnRecords: ImageView
        var btnSettings: ImageView
        var btnBack: ImageView

        btnDashboard = findViewById(R.id.btn_dashboard)
        btnAppointments = findViewById(R.id.btn_appointments)
        btnRecords = findViewById(R.id.btn_records)
        btnSettings = findViewById(R.id.btn_settings)
        btnBack = findViewById(R.id.book_appointment_back_icon)

        btnDashboard.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnAppointments.setOnClickListener {
            var intent = Intent(this, Appointments::class.java)
            startActivity(intent)
        }
        btnRecords.setOnClickListener {
            var intent = Intent(this, MedicalRecords::class.java)
            startActivity(intent)
        }
        btnSettings.setOnClickListener {
            var intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
        btnBack.setOnClickListener {
            var intent = Intent(this, NewAppointment::class.java)
            startActivity(intent)
        }
    }
}