package com.example.currencyapplication

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyapplication.Database.GraphValueDao


class GraphValueViewModelFactory (
    private val dataSource: GraphValueDao, // Data access object
    private val application: Application): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T:ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GraphValueViewModel::class.java)) { // ViewModel class
            return GraphValueViewModel(dataSource, application) as T // Call ViewModel constructor
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}