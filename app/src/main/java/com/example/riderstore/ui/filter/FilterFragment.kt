package com.example.riderstore.ui.filter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.riderstore.R

class FilterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val extraLocation = view.findViewById<LinearLayout>(R.id.extraLocationContainer)
        val extraPayment = view.findViewById<LinearLayout>(R.id.extraPaymentContainer)
        val extraDelivery = view.findViewById<LinearLayout>(R.id.extraDeliveryContainer)
        val extraColor = view.findViewById<LinearLayout>(R.id.extraColorContainer)

        val toggleLocation = view.findViewById<ImageView>(R.id.toggleLocationIcon)
        val togglePayment = view.findViewById<ImageView>(R.id.togglePaymentIcon)
        val toggleDelivery = view.findViewById<ImageView>(R.id.toggleDeliveryIcon)
        val toggleColor = view.findViewById<ImageView>(R.id.toggleColorIcon)

        val btnReset = view.findViewById<Button>(R.id.btn_reset)
        val btnApply = view.findViewById<Button>(R.id.btn_apply)

        toggleLocation.setOnClickListener {
            toggleSection(extraLocation, toggleLocation)
        }

        togglePayment.setOnClickListener {
            toggleSection(extraPayment, togglePayment)
        }

        toggleDelivery.setOnClickListener {
            toggleSection(extraDelivery, toggleDelivery)
        }

        toggleColor.setOnClickListener {
            toggleSection(extraColor, toggleColor)
        }
        btnReset.setOnClickListener {
            Toast.makeText(requireContext(), "Filter direset", Toast.LENGTH_SHORT).show()
        }

        btnApply.setOnClickListener {
            Toast.makeText(requireContext(), "Filter diterapkan", Toast.LENGTH_SHORT).show()
        }
    }

    private fun toggleSection(section: View, icon: ImageView) {
        if (section.visibility == View.VISIBLE) {
            section.animate()
                .alpha(0f)
                .setDuration(200)
                .withEndAction {
                    section.visibility = View.GONE
                    icon.setImageResource(R.drawable.ic_expand_more)
                }.start()
        } else {
            section.alpha = 0f
            section.visibility = View.VISIBLE
            section.animate()
                .alpha(1f)
                .setDuration(200)
                .withEndAction {
                    icon.setImageResource(R.drawable.ic_expand_less)
                }.start()
        }
    }
}
