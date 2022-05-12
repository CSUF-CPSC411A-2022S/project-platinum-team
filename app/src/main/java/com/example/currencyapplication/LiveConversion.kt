package com.example.currencyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.currencyapplication.conversion.ConversionViewModel
import com.example.currencyapplication.databinding.FragmentLiveConversionBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LiveConversion.newInstance] factory method to
 * create an instance of this fragment.
 */
class LiveConversion : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLiveConversionBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_live_conversion, container, false)
        // Inflate the layout for this fragment

        val model = ConversionViewModel()

        binding.conversionViewModel = model
        binding.lifecycleOwner = this

        return binding.root
    }
}