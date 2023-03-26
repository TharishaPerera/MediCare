package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.nibm.medicare.adapters.AppointmentsAdapter
import com.nibm.medicare.models.Appointments

class Appointments : AppCompatActivity() {

    var doctorsList = arrayListOf<com.nibm.medicare.models.Appointments>()
    private val api = "https://dbmssrwm2a.execute-api.us-east-1.amazonaws.com/prod/doctors"

    private lateinit var appointmentsRV : RecyclerView
    private lateinit var appointmentList : ArrayList<Appointments>
    private lateinit var appointmentsAdapter : AppointmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        appointmentsRV = findViewById(R.id.rv_appointments)
        handleNavigation()

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)
        val request = JsonObjectRequest(Request.Method.GET, api, null, { result ->
            val jsonArray = result.getJSONArray("doctors")
            for (i in 0 until jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(i)
                Log.d("Doctors List", jsonObject.toString())

                val doctors = com.nibm.medicare.models.Appointments(
                    jsonObject.getString("doctorMobile"),
                    jsonObject.getString("specialization"),
                    jsonObject.getString("doctorName"),
                    jsonObject.getString("doctorEmail"),
                    jsonObject.getString("doctorAddress"),
                    jsonObject.getString("doctorPassword"),
                    jsonObject.getString("doctorUserName"),
                    jsonObject.getString("doctorId")
                )

                doctorsList.add(doctors)
            }

            appointmentsRV.layoutManager = LinearLayoutManager(this)
            appointmentsRV.adapter = AppointmentsAdapter(doctorsList)

        }, {error ->
            Log.d("Error somewhere", error.message.toString())
        })

        requestQueue.add(request)
    }

    private fun handleNavigation(){
        var btnDashboard : ImageView
        var btnRecords : ImageView
        var btnSettings : ImageView
        var btnBack : ImageView
        var btnNewAppointment : Button

        btnDashboard = findViewById(R.id.btn_dashboard)
        btnRecords = findViewById(R.id.btn_records)
        btnSettings = findViewById(R.id.btn_settings)
        btnBack = findViewById(R.id.appointment_back_icon)
        btnNewAppointment = findViewById(R.id.btn_new_appointment)

        btnDashboard.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
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
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnNewAppointment.setOnClickListener {
            var intent = Intent(this, NewAppointment::class.java)
            startActivity(intent)
        }
    }
}