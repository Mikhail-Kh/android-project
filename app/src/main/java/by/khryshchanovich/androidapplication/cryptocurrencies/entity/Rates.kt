package by.khryshchanovich.androidapplication.cryptocurrencies.entity

data class Rates(
    val id: Int,
    val name: String,
    val symbol: String,
    val percentChange1h: Double,
    val price: Double
)