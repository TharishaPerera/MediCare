package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondIntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_intro)

        var txtNext : TextView
        var txtBack : TextView

        txtNext = findViewById(R.id.btn_s_intro_next)
        txtBack = findViewById(R.id.btn_s_intro_back)

        txtNext.setOnClickListener{
            var intent = Intent(this, ThirdIntroActivity::class.java)
            startActivity(intent)
        }

        txtBack.setOnClickListener{
            var intent = Intent(this, FirstIntroActivity::class.java)
            startActivity(intent)
        }
    }
}