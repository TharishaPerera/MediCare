package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        var btnDashboard : ImageView
        var btnAppointments : ImageView
        var btnRecords : ImageView
        var btnBack : ImageView
        var btnAccountSettings : LinearLayout

        btnDashboard = findViewById(R.id.btn_dashboard)
        btnAppointments = findViewById(R.id.btn_appointments)
        btnRecords = findViewById(R.id.btn_records)
        btnBack = findViewById(R.id.settings_back_icon)
        btnAccountSettings = findViewById(R.id.btn_account_settings)

        btnAccountSettings.setOnClickListener {
            var intent = Intent(this, AccountSettings::class.java)
            startActivity(intent)
        }

        btnDashboard.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnAppointments.setOnClickListener {
            var intent = Intent(this, Appointments::class.java)
            startActivity(intent)
        }
        btnBack.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
    }
}