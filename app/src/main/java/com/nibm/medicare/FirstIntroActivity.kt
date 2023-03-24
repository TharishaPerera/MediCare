package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class FirstIntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_intro)

        var txtNext : TextView
        var txtSkip : TextView

        txtNext = findViewById(R.id.btn_f_intro_next)
        txtSkip = findViewById(R.id.btn_skip)

        txtNext.setOnClickListener{
            var intent = Intent(this, SecondIntroActivity::class.java)
            startActivity(intent)
        }

        txtSkip.setOnClickListener{
            var intent = Intent(this, VerificationActivity::class.java)
            startActivity(intent)
        }
    }
}