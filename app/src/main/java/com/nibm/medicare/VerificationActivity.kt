package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class VerificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        var btnContinue : Button
        var txtChangeNo : TextView
        var txtResndCode : TextView
        var imgClear : ImageView
        var digi1 : EditText
        var digi2 : EditText
        var digi3 : EditText
        var digi4 : EditText

        btnContinue = findViewById(R.id.btn_continue)
        txtChangeNo = findViewById(R.id.txt_change_no)
        txtResndCode = findViewById(R.id.txt_resend_code)
        imgClear = findViewById(R.id.img_clear)
        digi1 = findViewById(R.id.txt_digi_1)
        digi2 = findViewById(R.id.txt_digi_2)
        digi3 = findViewById(R.id.txt_digi_3)
        digi4 = findViewById(R.id.txt_digi_4)

        imgClear.setOnClickListener{
            digi1.text = null
            digi2.text = null
            digi3.text = null
            digi4.text = null
        }

        txtChangeNo.setOnClickListener{
            var intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        btnContinue.setOnClickListener {
            var intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
        }

    }
}