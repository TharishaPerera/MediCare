package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nibm.medicare.adapters.MedicalRecordsAdapter
import com.nibm.medicare.models.MedicalRecords

class MedicalRecords : AppCompatActivity() {
    private lateinit var recordsRV : RecyclerView
    private lateinit var recordList : ArrayList<MedicalRecords>
    private lateinit var recordsAdapter: MedicalRecordsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_records)

        addMedicalRecords()
        handleNavigation()
    }

    private fun addMedicalRecords(){
        recordsRV = findViewById(R.id.rv_medical_records)
        recordsRV.setHasFixedSize(true)
        recordsRV.layoutManager = LinearLayoutManager(this)

        recordList = ArrayList()

        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))
        recordList.add(MedicalRecords("01/01/2023", "Dentist - Thor Odinson"))

        recordsAdapter = MedicalRecordsAdapter(recordList)
        recordsRV.adapter = recordsAdapter
    }

    private fun handleNavigation() {
        var btnDashboard: ImageView
        var btnAppointments: ImageView
        var btnSettings: ImageView
        var btnBack: ImageView

        btnDashboard = findViewById(R.id.btn_dashboard)
        btnAppointments = findViewById(R.id.btn_appointments)
        btnSettings = findViewById(R.id.btn_settings)
        btnBack = findViewById(R.id.records_back_icon)

        btnDashboard.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnAppointments.setOnClickListener {
            var intent = Intent(this, Appointments::class.java)
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