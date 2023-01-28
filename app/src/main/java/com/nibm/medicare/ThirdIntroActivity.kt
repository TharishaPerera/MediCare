package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdIntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_intro)

        var txtNext : TextView
        var txtBack : TextView

        txtNext = findViewById(R.id.btn_t_intro_next)
        txtBack = findViewById(R.id.btn_t_intro_back)

        txtNext.setOnClickListener{
            var intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }

        txtBack.setOnClickListener{
            var intent = Intent(this, SecondIntroActivity::class.java)
            startActivity(intent)
        }
    }
}