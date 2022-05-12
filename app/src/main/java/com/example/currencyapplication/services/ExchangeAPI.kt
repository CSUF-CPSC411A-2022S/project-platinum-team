package com.example.currencyapplication.services

import com.example.currencyapplication.conversion.GetConversionResponse
import com.example.currencyapplication.conversion.GetSymbolsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

class ExchangeAPI {
    companion object Exchange {
        // Base URL of the API
        private const val BASE_URL = "https://api.apilayer.com/exchangerates_data/"

        // Acess token. Replace with your own in future projects.
        const val ACCESS_TOKEN = "L0H9j44R3Nlx0H4HJIViz9dWg2qYz5lW"

        // Moshi object used to parse JSON.
        private val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        // Retrofit object for retrieving data from the internet. We use
        // Moshi to parse data returned by the API
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

        // List of API endpoints you want to access
        interface ExchangeRateAPI {
            /**
             * Retrieves a valid address that closely matches the search string.
             *
             * The @GET annotation describes the API endpoint. You can include
             * variables using {} that enclose a variable name.
             *
             * The @PATH annotation assigns the parameter value to the variable
             * on the URL string marked with { }.
             *
             * The @Query annotation adds a query to the end of the URL with the
             * specified name and value from the associated parameter.
             *
             * @param search search string
             * @param token access token
             * @return Place object built from the API data
             */
            @Headers(
                "apikey: L0H9j44R3Nlx0H4HJIViz9dWg2qYz5lW"
            )
            @GET("convert")
            fun getConversion(@Query(value = "to") to: String,
                              @Query(value = "from") from: String,
                              @Query(value = "amount") amount: String):
                    Call<GetConversionResponse>

            @Headers(
                "apikey: L0H9j44R3Nlx0H4HJIViz9dWg2qYz5lW"
            )
            @GET("symbols")
            fun getSymbols():
                    Call<GetSymbolsResponse>
        }


        object Api {
            /**
             * By lazy allows us to create an uninitialized constant proprerty.
             * It will be assigned a value returned by the closure when it is
             * accessed the first time thereby saving processing time.
             */
            val retrofitService : ExchangeRateAPI by lazy {
                retrofit.create(ExchangeRateAPI::class.java) }
        }
    }
}