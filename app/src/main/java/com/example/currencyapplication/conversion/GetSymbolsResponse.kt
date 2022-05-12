package com.example.currencyapplication.conversion

data class GetSymbolsResponse(
    val success: Boolean,
    val symbols: Map<String, String>
)