package com.example.riderstore.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.riderstore.MainActivity
import com.example.riderstore.databinding.ActivityLoginBinding
import com.example.riderstore.ui.home.HomeFragment
import com.example.riderstore.ui.register.RegisterActivity
import com.example.riderstore.utils.hashSHA256
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferences = getSharedPreferences("USER_PREFS", MODE_PRIVATE)

        // Mengatur listener untuk tombol Login
        binding.buttonLogin?.setOnClickListener {
            val username = binding.editUsername?.text.toString().trim()
            val password = binding.editPassword?.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Snackbar.make(
                    binding.root,
                    "Mohon isi username dan password.",
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            val savedUsername = preferences.getString("USERNAME", "")
            val savedPasswordHash = preferences.getString("PASSWORD", "")
            val hashedInputPassword = hashSHA256(password)

            if (username == savedUsername && hashedInputPassword == savedPasswordHash) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Snackbar.make(
                    binding.root,
                    "Username atau password salah.",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        // Kalau klik buat akun, maka masuk ke register
        binding.buatAkunLink?.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Fitur lupa password belum ada
        binding.lupaPasswordLink?.setOnClickListener {
            Snackbar.make(
                binding.root,
                "Fitur lupa password belum tersedia.",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }
}
