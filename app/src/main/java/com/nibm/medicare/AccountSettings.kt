package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class AccountSettings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_settings)

        handleNavigation()
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
        btnBack = findViewById(R.id.account_settings_back_icon)

        btnDashboard.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }
        btnSettings.setOnClickListener {
            var intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
        btnBack.setOnClickListener {
            var intent = Intent(this, Settings::class.java)
            startActivity(intent)
        }
    }
}