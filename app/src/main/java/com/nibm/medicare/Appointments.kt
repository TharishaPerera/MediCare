package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.adapters.AppointmentsAdapter
import com.nibm.medicare.models.Appointments

class Appointments : AppCompatActivity() {
    private lateinit var appointmentsRV : RecyclerView
    private lateinit var appointmentList : ArrayList<Appointments>
    private lateinit var appointmentsAdapter : AppointmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        addAppointments()
        handleNavigation()
    }

    private fun addAppointments(){
        appointmentsRV = findViewById(R.id.rv_appointments)
        appointmentsRV.setHasFixedSize(true)
        appointmentsRV.layoutManager = LinearLayoutManager(this)

        appointmentList = ArrayList()

        appointmentList.add(Appointments("01/01/2023", "Dentist - Thor Odinson"))
        appointmentList.add(Appointments("01/01/2023", "Dentist - Thor Odinson"))
        appointmentList.add(Appointments("01/01/2023", "Dentist - Thor Odinson"))
        appointmentList.add(Appointments("02/02/2023", "Psycologist - Loki Odinson"))
        appointmentList.add(Appointments("03/03/2023", "Eye Specialist - Tony Stark"))
        appointmentList.add(Appointments("03/03/2023", "Eye Specialist - Tony Stark"))
        appointmentList.add(Appointments("03/03/2023", "Eye Specialist - Tony Stark"))
        appointmentList.add(Appointments("04/04/2023", "Dentist - Thor Odinson"))
        appointmentList.add(Appointments("05/05/2023", "Dentist - Thor Odinson"))
        appointmentList.add(Appointments("06/06/2023", "Dentist - Thor Odinson"))

        appointmentsAdapter = AppointmentsAdapter(appointmentList)
        appointmentsRV.adapter = appointmentsAdapter
    }

    private fun handleNavigation(){
        var btnDashboard : ImageView
        var btnRecords : ImageView
        var btnSettings : ImageView
        var btnBack : ImageView

        btnDashboard = findViewById(R.id.btn_dashboard)
        btnRecords = findViewById(R.id.btn_records)
        btnSettings = findViewById(R.id.btn_settings)
        btnBack = findViewById(R.id.appointment_back_icon)

        btnDashboard.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnSettings.setOnClickListener {
            var intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
        btnBack.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}