package com.example.currencyapplication.conversion

data class GetConversionResponse(
    val date: String,
    val info: Info,
    val query: Query,
    val result: Double,
    val success: Boolean
)