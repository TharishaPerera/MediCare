package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.nibm.medicare.adapters.AppointmentsAdapter
import com.nibm.medicare.adapters.NewAppointmentsAdapter
import com.nibm.medicare.models.NewAppointments

class NewAppointment : AppCompatActivity() {

    var doctorsList = arrayListOf<com.nibm.medicare.models.Appointments>()
    val api = "https://dbmssrwm2a.execute-api.us-east-1.amazonaws.com/prod/doctors"

    private lateinit var newAppointmentsRV : RecyclerView
    private lateinit var newAppointmentList : ArrayList<NewAppointments>
    private lateinit var newAppointmentsAdapter : NewAppointmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_appointment)

        newAppointmentsRV = findViewById(R.id.rv_new_appointments)
        //addNewAppointmentData()
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

            newAppointmentsRV.layoutManager = LinearLayoutManager(this)
            newAppointmentsRV.adapter = AppointmentsAdapter(doctorsList)

        }, {error ->
            Log.d("Error somewhere", error.message.toString())
        })

        requestQueue.add(request)

//        newAppointmentsAdapter.onItemClick = {
//            val intent = Intent(this, DoctorDetails::class.java)
//            intent.putExtra("doctor", it)
//            startActivity(intent)
//        }
    }

//    private fun addNewAppointmentData() {
//        newAppointmentsRV = findViewById(R.id.rv_new_appointments)
//        newAppointmentsRV.setHasFixedSize(true)
//        newAppointmentsRV.layoutManager = LinearLayoutManager(this)
//
//        newAppointmentList = ArrayList()
//
//        newAppointmentList.add(NewAppointments("Thor", "Dentist", "colombo - 1km", "(111)", R.drawable.user_ico, "Monday, 01 Jan", "Ja Ela", "06:00"))
//        newAppointmentList.add(NewAppointments("Loki", "Psyco", "colombo - 2km", "(222)", R.drawable.appointment_img_lg, "Tuesday, 01 Jan", "Colombo", "07:00"))
//        newAppointmentList.add(NewAppointments("Abc", "wkhfidsaf", "colombo - 3km", "(333)", R.drawable.calendar_fade_ico, "Wednesday, 01 Jan", "Matara", "08:00"))
//        newAppointmentList.add(NewAppointments("Hulk", "Dentfdsfist", "colombo - 4km", "(444)", R.drawable.cross_ico, "Thursday, 01 Jan", "Jaffna", "09:00"))
//        newAppointmentList.add(NewAppointments("Cap", "Dentdfsadist", "colombo - 5km", "(555)", R.drawable.user_ico, "Friday, 01 Jan", "Kandy", "10:00"))
//        newAppointmentList.add(NewAppointments("Nat", "ryrty", "colombo - 6km", "(666)", R.drawable.user_ico, "Saturday, 01 Jan", "Kandana", "11:00"))
//        newAppointmentList.add(NewAppointments("baba", "Ddfsadentist", "fsdf - 7km", "(777)", R.drawable.user_ico, "Sunday, 01 Jan", "Ragama", "12:00"))
//        newAppointmentList.add(NewAppointments("kaka", "fasdf", "colombo - 8km", "(888)", R.drawable.user_ico, "Monday, 01 Jan", "Colombo", "13:00"))
//        newAppointmentList.add(NewAppointments("jaja", "dfasdf", "fadsf - 9km", "(999)", R.drawable.user_ico, "Tuesday, 01 Jan", "Ja Ela", "14:00"))
//
//        newAppointmentsAdapter = NewAppointmentsAdapter(newAppointmentList)
//        newAppointmentsRV.adapter = newAppointmentsAdapter
//
//        newAppointmentsAdapter.onItemClick = {
//            val intent = Intent(this, DoctorDetails::class.java)
//            intent.putExtra("doctor", it)
//            startActivity(intent)
//        }
//    }

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