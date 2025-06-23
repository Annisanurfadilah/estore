package com.example.riderstore.ui.checkout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.riderstore.MainActivity
import com.example.riderstore.R

class CheckoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnBack = view.findViewById<ImageButton>(R.id.btn_back_checkout)
        val btnSubmit = view.findViewById<Button>(R.id.btn_checkout_submit)
        val totalPrice = view.findViewById<TextView>(R.id.checkout_total_price)

        val harga = arguments?.getString("TOTAL_HARGA") ?: "Rp. 0"
        totalPrice.text = harga

        btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        btnSubmit.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Pesanan berhasil dibuat!\nTotal: ${totalPrice.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).hideBottomBar()
    }

    override fun onStop() {
        super.onStop()
        (requireActivity() as MainActivity).showBottomBar()
    }
}
