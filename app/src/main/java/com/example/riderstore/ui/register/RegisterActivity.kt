package com.example.riderstore.ui.register

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.riderstore.databinding.ActivityRegisterBinding
import com.example.riderstore.ui.login.LoginActivity
import com.example.riderstore.utils.hashSHA256
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var preferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        preferences = getSharedPreferences("USER_PREFS", MODE_PRIVATE)

        binding.buttonRegister.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val email = binding.editEmail.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Snackbar.make(binding.root, "Mohon lengkapi semua data!", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hashedPassword = hashSHA256(password)

            preferences.edit().apply {
                putString("USERNAME", username)
                putString("EMAIL", email)
                putString("PASSWORD", hashedPassword)
                apply()
            }

            Snackbar.make(binding.root, "Registrasi berhasil! Silakan login.", Snackbar.LENGTH_SHORT).show()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }

        binding.loginLink.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
