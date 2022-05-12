package com.example.currencyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.currencyapplication.databinding.HomeBinding

class home : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = HomeBinding.inflate(layoutInflater)

        binding.CurrencyButton.setOnClickListener() { view: View ->
            view.findNavController().navigate(R.id.action_Home_to_currencies)
        }

        binding.GraphButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_Home_to_graphOptions)
        }

        return binding.root
    }



  }

