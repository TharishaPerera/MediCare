package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val dropCC : Spinner
        val btnSignin : Button
        val txtMobileNo : EditText

        var countyCodes = resources.getStringArray(R.array.country_codes)

        dropCC = findViewById(R.id.drop_country_code)
        btnSignin = findViewById(R.id.btn_signin)

        if (dropCC != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countyCodes)
            dropCC.adapter = adapter
        }

        btnSignin.setOnClickListener{
            var intent = Intent(this, VerificationActivity::class.java)
            startActivity(intent)
        }
    }
}