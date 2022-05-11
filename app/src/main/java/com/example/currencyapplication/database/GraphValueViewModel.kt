package com.example.currencyapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.currencyapplication.database.GraphValue
import com.example.currencyapplication.database.GraphValueDao
import kotlinx.coroutines.launch

class GraphValueViewModel(
    val database: GraphValueDao, // Data access object for the Intersection entity
    application: Application
) : AndroidViewModel(application) {

    var date = MutableLiveData("")
    var rub = MutableLiveData("")
    var yen = MutableLiveData("")
    var rup = MutableLiveData("")

    // Retrieves all Intersection objects from the database
    // Represented as a LiveData<List<Intersection>>
    val graphValueList = database.getAllGraphValue()

    /**
     * Creates a LiveData<String> that contains information from all Intersection objects.
     * The Transformations.map function takes a LiveData object, performs operations on the
     * object and returns a LiveData-wrapped object.
     */
    var graphValueString = Transformations.map(graphValueList) {
            graphValues -> // intersections refer to the underlying data List<Intersection>
        var result = ""
        // Retrieve each Intersection object from the list
        for (graphValue in graphValues) {
            // Create a string using the Intersection name and location.
            // The intersection string is appended to a longer string with all intersections.
            result += "${graphValue.rub} @ ${graphValue.yen} @ ${graphValue.rup} \n"
        }
        // Returns the aggregated String that is wrapped by the map function in a LiveData object.
        result
    }

    /**
     * Inserts the Intersection object into the database.
     */
    fun insert() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Create Intersection object using data stored in the EditText views
            var graphValue = GraphValue()

            graphValue.rub = 71.354
            graphValue.yen = 130.0889
            graphValue.rup = 76.528


            var graphValue2 = GraphValue()
            graphValue2.rub = 70.697
            graphValue2.yen = 130.1561
            graphValue2.rup = 76.521

            var graphValue3 = GraphValue()
            graphValue3.rub = 67.230
            graphValue3.rup = 76.528
            graphValue3.yen = 130.1014

            var graphValue4 = GraphValue()
            graphValue4.rub = 66.984
            graphValue4.rup = 75.983
            graphValue4.yen = 129.4889

            var graphValue5 = GraphValue()
            graphValue5.rub = 64.990
            graphValue5.rup = 76.513
            graphValue5.yen = 130.1082

            var graphValue6 = GraphValue()
            graphValue6.rub = 69.003
            graphValue6.rup = 76.956
            graphValue6.yen = 130.5802

            var graphValue7 = GraphValue()
            graphValue7.rub = 66.502
            graphValue7.rup = 76.953
            graphValue7.yen = 130.5373

            // Insert data to the database using the insert coroutine.
            database.insert(graphValue)
            database.insert(graphValue2)
            database.insert(graphValue3)
            database.insert(graphValue4)
            database.insert(graphValue5)
            database.insert(graphValue6)
            database.insert(graphValue7)

        }

    }

    /**
     * Deletes all Intersection entities in the database.
     */
    fun clear() {
        // Launch coroutines in the viewModelScope so that the coroutines are automatically
        // canceled when the ViewModel is destroyed.
        viewModelScope.launch {
            // Delete data from the database using the clear coroutine.
            database.clear()
        }
    }
}