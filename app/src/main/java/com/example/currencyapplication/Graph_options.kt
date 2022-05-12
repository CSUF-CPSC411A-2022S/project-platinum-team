package com.example.currencyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.currencyapplication.databinding.FragmentGraphOptionsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [Graph_options.newInstance] factory method to
 * create an instance of this fragment.
 */
class GraphOptions : Fragment() {
    // TODO: Rename and change types of parameters
    //private var binding: FragmentGraphOptionsBinding? = null
    //private val binding get() = binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

         val binding = FragmentGraphOptionsBinding.inflate(inflater, container, false)

        val pick = resources.getStringArray(R.array.Currency)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, pick)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        return binding.root

        //return inflater.inflate(R.layout.fragment_graph_options, container, false)
    }


}