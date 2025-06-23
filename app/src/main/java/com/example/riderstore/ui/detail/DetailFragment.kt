package com.example.riderstore.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.riderstore.R
import com.example.riderstore.ui.checkout.CheckoutFragment
import com.example.riderstore.ui.keranjang.KeranjangFragment

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.btn_back)?.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        view.findViewById<Button>(R.id.btn_add_cart)?.setOnClickListener {
            val intent = Intent(requireContext(), KeranjangFragment::class.java)
            startActivity(intent)
        }

        view.findViewById<Button>(R.id.btn_buy_now)?.setOnClickListener {
            val intent = Intent(requireContext(), CheckoutFragment::class.java)
            startActivity(intent)
        }
    }
}
