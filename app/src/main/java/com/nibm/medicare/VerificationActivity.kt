package com.nibm.medicare

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.android.volley.toolbox.Volley

class VerificationActivity : AppCompatActivity() {
    private var generatedOTP : Int = 0
    private var mobileNumber : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification)

        val bundle = intent.extras
        if (bundle != null){
            generatedOTP = bundle.getInt("OTP")
            mobileNumber = bundle.getString("mobileNumber").toString()
        }

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
            clearFields(digi1, digi2, digi3, digi4)
            enableDigi1(digi1, digi2, digi3, digi4)
        }

        txtResndCode.setOnClickListener {
            resendCode()
            clearFields(digi1, digi2, digi3, digi4)
            enableDigi1(digi1, digi2, digi3, digi4)
        }

        txtChangeNo.setOnClickListener{
            var intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        btnContinue.setOnClickListener {
            val userOtp = digi1.text.toString() + digi2.text.toString() + digi3.text.toString() + digi4.text.toString()

            if (userOtp.length == 4) {
                if (userOtp.toString() == generatedOTP.toString()) {
                    Toast.makeText(applicationContext, "Verification successful", Toast.LENGTH_LONG)
                        .show()
                var intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
                } else {
                    Toast.makeText(applicationContext, "Verification failed. Invalid OTP.", Toast.LENGTH_LONG)
                        .show()
                    clearFields(digi1, digi2, digi3, digi4)
                    enableDigi1(digi1, digi2, digi3, digi4)
                }
            } else {
                Toast.makeText(applicationContext, "Invalid OTP.", Toast.LENGTH_LONG)
                    .show()
                clearFields(digi1, digi2, digi3, digi4)
                enableDigi1(digi1, digi2, digi3, digi4)
            }
        }

    }

    private fun resendCode() {
        var sms = SMS()
        val OTP = sms.generateOTP()
        generatedOTP = OTP
        try {
            val queue = Volley.newRequestQueue(this)
            sms.sendOTP(mobileNumber, OTP, queue)

            Toast.makeText(applicationContext, "OTP Sent", Toast.LENGTH_LONG).show()
        } catch (error: Exception) {
            println(error.message)
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

    private fun clearFields(digi1: EditText, digi2: EditText, digi3: EditText, digi4: EditText){
        digi1.text = null
        digi2.text = null
        digi3.text = null
        digi4.text = null
    }

    private fun enableDigi1(digi1: EditText, digi2: EditText, digi3: EditText, digi4: EditText) {
        digi1.requestFocus()
        digi2.isEnabled = false
        digi3.isEnabled = false
        digi4.isEnabled = false
    }

}