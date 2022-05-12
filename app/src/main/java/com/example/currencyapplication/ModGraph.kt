package com.example.currencyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.currencyapplication.R


/**
 * A simple [Fragment] subclass.
 * Use the [ModGraph.newInstance] factory method to
 * create an instance of this fragment.
 */
class ModGraph : Fragment() {
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        var g = Graph(requireContext())
        return g.rootView
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.modgraph, container, false)

    }


}