package com.example.currencyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.currencyapplication.databinding.FragmentCurrenciesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [Currencies.newInstance] factory method to
 * create an instance of this fragment.
 */
class Currencies : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCurrenciesBinding.inflate(layoutInflater)
        val Currencies = resources.getStringArray(R.array.Currencies)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, Currencies)
        binding.currencyFrom.setAdapter(arrayAdapter)
        binding.currencyTo.setAdapter(arrayAdapter)

        return binding.root
    }
}