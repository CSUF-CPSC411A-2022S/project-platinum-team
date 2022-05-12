package com.example.currencyapplication.conversion

data class Query(
    val amount: Any,
    val from: String,
    val to: String
)