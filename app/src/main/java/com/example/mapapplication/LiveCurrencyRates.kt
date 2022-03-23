package com.example.mapapplication

import org.json.JSONObject

class LiveCurrencyRates() {
    // store json data fetched from api in this variable
    private var rateData: JSONObject? = null

    fun updateRates (data: JSONObject) {
        rateData = data
    }

    fun recentRates (){
        // return json object of recent updated rates
    }
}