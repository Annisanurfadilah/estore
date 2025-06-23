package com.example.riderstore

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.riderstore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_filter, R.id.navigation_keranjang,
                R.id.navigation_notifikasi, R.id.navigation_account
            )
        )
        binding.navView.setupWithNavController(navController)
    }

    /**
     * Fungsi untuk menampilkan bottom bar
     */
    fun showBottomBar() {
        binding.navView.visibility = android.view.View.VISIBLE
    }

    /**
     * Fungsi untuk menyembunyikan bottom bar
     */
    fun hideBottomBar() {
        binding.navView.visibility = android.view.View.GONE
    }
}
