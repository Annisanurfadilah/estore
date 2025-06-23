package com.example.riderstore

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.riderstore.ui.login.LoginActivity

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        window.decorView.postDelayed(
            {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            },
            3000
        )
    }
}
