package com.nibm.medicare

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val splashLogo : ImageView = findViewById(R.id.splash_logo)
        splashLogo.alpha = 0f
        splashLogo.animate().setDuration(1500).alpha(1f).withEndAction {
            val intent = Intent(this, FirstIntroActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}