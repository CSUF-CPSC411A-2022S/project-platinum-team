package com.example.currencyapplication.conversion

import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyapplication.R
import com.example.currencyapplication.databinding.FragmentCurrenciesBinding
import com.example.currencyapplication.services.ExchangeAPI
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ConversionViewModel: ViewModel() {

    private val _result = MutableLiveData("")

    val result: LiveData<String>
        get() {
            return _result
        }

    private val _fromSymbol = MutableLiveData("")

    val fromSymbol: LiveData<String>
        get() {
            return _fromSymbol
        }

    private val _toSymbol = MutableLiveData("")

    val toSymbol: LiveData<String>
        get() {
            return _toSymbol
        }

    fun getConversion(to: String, from: String, amount: String) {
        Log.d(to,"to")
        Log.d(from,"from")
        Log.d(amount,"amount")

        // Run API request as a coroutine to not block the application.
        viewModelScope.launch {
            ExchangeAPI.Exchange.Api.retrofitService.getConversion(to, from, amount).enqueue(
                object : Callback, retrofit2.Callback<GetConversionResponse> {
                    override fun onResponse(call: Call<GetConversionResponse>, response: Response<GetConversionResponse>) {
                        _result.value = response.body()?.result?.toBigDecimal()?.toPlainString()
                        _fromSymbol.value = response.body()?.query?.from
                        _toSymbol.value = response.body()?.query?.to
                    }
                    override fun onFailure(call: Call<GetConversionResponse>, t: Throwable) {
                        _result.value = "Failure ${t.message}"
                    }
                })
        }
    }

    fun getSymbols() {
        // Run API request as a coroutine to not block the application.
        viewModelScope.launch {
            ExchangeAPI.Exchange.Api.retrofitService.getSymbols().enqueue(
                object : Callback, retrofit2.Callback<GetSymbolsResponse> {
                    override fun onResponse(call: Call<GetSymbolsResponse>, response: Response<GetSymbolsResponse>) {
                        Log.d(response.body()?.symbols.toString(), "result")
                        _result.value = response.body()?.symbols.toString()
                    }
                    override fun onFailure(call: Call<GetSymbolsResponse>, t: Throwable) {
                        _result.value = "Failure ${t.message}"
                    }
                })
        }
    }
}