package com.example.mapapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.mapapplication.databinding.FragmentCurrenciesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [currencies.newInstance] factory method to
 * create an instance of this fragment.
 */
class currencies : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCurrenciesBinding.inflate(layoutInflater)
        val Currencies = resources.getStringArray(R.array.Currencies)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, Currencies)
        binding.currencyFrom.setAdapter(arrayAdapter)
        return binding.root
    }

}