package model

import kotlinx.serialization.Serializable

@Serializable
data class StockQuote(
    val symbol: String,
    val price: Double,
    val change: Double
)

@Serializable
data class Fundamentals(
    val peRatio: Double,
    val marketCap: Long,
    val revenue: Long
)
