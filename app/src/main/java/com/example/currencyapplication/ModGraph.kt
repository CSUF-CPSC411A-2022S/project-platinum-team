package com.example.currencyapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.currencyapplication.R
import com.example.currencyapplication.database.GraphValue
import com.example.currencyapplication.database.GraphValueDatabase
import com.example.currencyapplication.database.GraphValueViewModel
import com.example.currencyapplication.database.GraphValueViewModelFactory
import com.example.currencyapplication.databinding.ModgraphBinding


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

        // Inflate the layout for this fragment
        val binding: ModgraphBinding =
            DataBindingUtil.inflate(inflater, R.layout.modgraph, container, false)

        // Get reference to the application
        val application = requireNotNull(this.activity).application

        // Retrieve Intersection data access object.
        val dataSource = GraphValueDatabase.getInstance(application).GraphValueDao

        // Create a factory that generates IntersectionViewModels connected to the database.
        val viewModelFactory = GraphValueViewModelFactory(dataSource, application)

        //return inflater.inflate(R.layout.modgraph, container, false)
        val graphValueViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(GraphValueViewModel::class.java)

        // Connect the IntersectionViewModel with the variable in the layout
        binding.GraphValueViewModel = GraphValueViewModel
        // Assign the lifecycle owner to the activity so it manages the data accordingly.
        binding.lifecycleOwner = this

        return binding.root
        return g.rootView

    }


}