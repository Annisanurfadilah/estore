package com.example.riderstore.ui.keranjang

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.riderstore.MainActivity
import com.example.riderstore.R

class KeranjangFragment : Fragment() {

    private val hargaProduk = listOf(
        3_499_000,
        699_000,
        5_299_000
    )

    private lateinit var checkProduct1: CheckBox
    private lateinit var checkProduct2: CheckBox
    private lateinit var checkProduct3: CheckBox

    private lateinit var checkStore1: CheckBox
    private lateinit var checkStore2: CheckBox
    private lateinit var checkStore3: CheckBox

    private lateinit var checkAll: CheckBox
    private lateinit var totalPriceText: TextView
    private lateinit var btnCheckout: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_keranjang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupListeners()

        val btnBack = view.findViewById<ImageButton>(R.id.btn_toolbar_back)
        btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun initViews(view: View) {
        checkProduct1 = view.findViewById(R.id.check_product_1)
        checkProduct2 = view.findViewById(R.id.check_product_2)
        checkProduct3 = view.findViewById(R.id.check_product_3)

        checkStore1 = view.findViewById(R.id.check_store_1)
        checkStore2 = view.findViewById(R.id.check_store_2)
        checkStore3 = view.findViewById(R.id.check_store_3)

        checkAll = view.findViewById(R.id.check_all)
        totalPriceText = view.findViewById(R.id.total_price)
        btnCheckout = view.findViewById(R.id.btn_checkout)
    }

    private fun setupListeners() {
        checkAll.setOnCheckedChangeListener { _, isChecked ->
            checkProduct1.isChecked = isChecked
            checkProduct2.isChecked = isChecked
            checkProduct3.isChecked = isChecked
            checkStore1.isChecked = isChecked
            checkStore2.isChecked = isChecked
            checkStore3.isChecked = isChecked
            updateTotalPrice()
        }

        listOf(checkProduct1, checkProduct2, checkProduct3).forEach {
            it.setOnCheckedChangeListener { _, _ -> updateTotalPrice() }
        }

        checkStore1.setOnCheckedChangeListener { _, isChecked -> checkProduct1.isChecked = isChecked }
        checkStore2.setOnCheckedChangeListener { _, isChecked -> checkProduct2.isChecked = isChecked }
        checkStore3.setOnCheckedChangeListener { _, isChecked -> checkProduct3.isChecked = isChecked }

        btnCheckout.setOnClickListener {
            navigateToCheckout()
        }
    }

    private fun updateTotalPrice() {
        var total = 0
        if (checkProduct1.isChecked) total += hargaProduk[0]
        if (checkProduct2.isChecked) total += hargaProduk[1]
        if (checkProduct3.isChecked) total += hargaProduk[2]

        totalPriceText.text = "Total: Rp. %,d".format(total).replace(',', '.')
    }

    private fun navigateToCheckout() {
        val totalPrice = totalPriceText.text
            .toString()
            .replace("Total: ", "")

        // Kirim total harga sebagai argument
        val bundle = Bundle().apply {
            putString("TOTAL_HARGA", totalPrice)
        }

        // Pastikan action ini ada di nav_graph.xml
        findNavController().navigate(
            R.id.action_keranjangFragment_to_checkoutFragment,
            bundle
        )
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
