package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        var signInButton : Button = findViewById(R.id.sign_in_button)
        var signUpButton : Button = findViewById(R.id.sign_up_button)

        signInButton.setOnClickListener{
            var intent = Intent(this, VerificationActivity::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            var intent = Intent(this, UserCreation::class.java)
            startActivity(intent)
        }
    }
}