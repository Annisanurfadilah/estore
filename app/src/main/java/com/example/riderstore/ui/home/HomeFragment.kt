package com.example.riderstore.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.navigation.fragment.findNavController
import com.example.riderstore.R
import com.example.riderstore.ui.detail.DetailFragment
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val yamahaXsr = view.findViewById<LinearLayout>(R.id.yamaha_xsr)
        yamahaXsr.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }

    }
}