package com.example.mapapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.currencyapplication.R
import com.example.currencyapplication.databinding.FragmentCurrenciesBinding

class Currencies : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCurrenciesBinding.inflate(layoutInflater)
        val Currencies = resources.getStringArray(R.array.Currencies)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, Currencies)
        binding.currencyFrom.setAdapter(arrayAdapter)
        binding.currencyTo.setAdapter(arrayAdapter)

        return binding.root
    }

}