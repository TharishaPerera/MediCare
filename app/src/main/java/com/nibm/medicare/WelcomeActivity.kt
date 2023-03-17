package com.nibm.medicare

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.Volley


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
        txtMobileNo = findViewById(R.id.txt_mobile_number)

        if (dropCC != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countyCodes)
            dropCC.adapter = adapter
        }

        btnSignin.setOnClickListener{
            var sms = SMS()

            var cc = dropCC.selectedItem.toString()
            var number = txtMobileNo.text.toString()
            var mobileNumber = cc + number

            if (number != "") {
                val OTP = sms.generateOTP()
                try {
                    val queue = Volley.newRequestQueue(this)
                    sms.sendOTP(mobileNumber, OTP, queue)

                    Toast.makeText(applicationContext, "OTP Sent", Toast.LENGTH_LONG).show()

                    var intent = Intent(this, VerificationActivity::class.java)
                    intent.putExtra("OTP", OTP)
                    intent.putExtra("mobileNumber", mobileNumber)
                    startActivity(intent)
                } catch (error: Exception) {
                    println(error.message)
                }
            } else {
                Toast.makeText(applicationContext, "Please enter mobile number.", Toast.LENGTH_LONG).show()
            }
        }
    }
}