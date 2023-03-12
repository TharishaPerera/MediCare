package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.addTextChangedListener

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

        changeFocus(digi1, digi2, digi3, digi4)

        imgClear.setOnClickListener{
            digi1.text = null
            digi2.text = null
            digi3.text = null
            digi4.text = null

            enableDigi1(digi1, digi2, digi3, digi4)
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

    private fun changeFocus(digi1: EditText, digi2: EditText, digi3: EditText, digi4: EditText) {
        enableDigi1(digi1, digi2, digi3, digi4)

        digi1.addTextChangedListener {
            if (digi1.text.isNotEmpty()){
                digi2.isEnabled = true
                digi2.requestFocus()
            }
        }
        digi2.addTextChangedListener {
            if (digi2.text.isNotEmpty()){
                digi3.isEnabled = true
                digi3.requestFocus()
            }
        }
        digi3.addTextChangedListener {
            if (digi3.text.isNotEmpty()){
                digi4.isEnabled = true
                digi4.requestFocus()
            }
        }
    }

    private fun enableDigi1(digi1: EditText, digi2: EditText, digi3: EditText, digi4: EditText) {
        digi1.requestFocus()
        digi2.isEnabled = false
        digi3.isEnabled = false
        digi4.isEnabled = false
    }

}