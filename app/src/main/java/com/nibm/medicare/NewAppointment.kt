package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.adapters.NewAppointmentsAdapter
import com.nibm.medicare.models.NewAppointments

class NewAppointment : AppCompatActivity() {
    private lateinit var newAppointmentsRV : RecyclerView
    private lateinit var newAppointmentList : ArrayList<NewAppointments>
    private lateinit var newAppointmentsAdapter : NewAppointmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_appointment)

        addNewAppointmentData()
        handleNavigation()
    }

    private fun addNewAppointmentData() {
        newAppointmentsRV = findViewById(R.id.rv_new_appointments)
        newAppointmentsRV.setHasFixedSize(true)
        newAppointmentsRV.layoutManager = LinearLayoutManager(this)

        newAppointmentList = ArrayList()

        newAppointmentList.add(NewAppointments("Thor", "Dentist", "colombo - 5km", "(555)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Loki", "Psyco", "colombo - 5km", "(555)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Abc", "wkhfidsaf", "colombo - 5km", "(555)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Hulk", "Dentfdsfist", "colombo - 5km", "(555)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Cap", "Dentdfsadist", "colombo - 5km", "(555)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Thor", "ryrty", "colombo - 5km", "(231)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Thor", "Ddfsadentist", "fsdf - 5km", "(555)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Thor", "fasdf", "colombo - 5km", "(123)", R.drawable.user_ico))
        newAppointmentList.add(NewAppointments("Thor", "dfasdf", "fadsf - 10km", "(3123)", R.drawable.user_ico))

        newAppointmentsAdapter = NewAppointmentsAdapter(newAppointmentList)
        newAppointmentsRV.adapter = newAppointmentsAdapter
    }

    private fun handleNavigation(){
        var btnDashboard : ImageView
        var btnAppointments : ImageView
        var btnRecords : ImageView
        var btnSettings : ImageView
        var btnBack : ImageView

        btnDashboard = findViewById(R.id.btn_dashboard)
        btnAppointments = findViewById(R.id.btn_appointments)
        btnRecords = findViewById(R.id.btn_records)
        btnSettings = findViewById(R.id.btn_settings)
        btnBack = findViewById(R.id.new_appointment_back_icon)

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
            var intent = Intent(this, Appointments::class.java)
            startActivity(intent)
        }
    }
}