package by.khryshchanovich.androidapplication.cryptocurrencies.mappers

import by.khryshchanovich.androidapplication.cryptocurrencies.dto.RatesResponse
import by.khryshchanovich.androidapplication.cryptocurrencies.entity.Rates

class RatesMapper {

    fun map(from: RatesResponse.Data?): Rates {
        return Rates(
            id = from?.id ?: 0,
            name = from?.name.orEmpty(),
            symbol = from?.symbol.orEmpty(),
            percentChange1h = from?.quote?.uSD?.percentChange1h ?: 0.0,
            price = from?.quote?.uSD?.price ?: 0.0
        )
    }
}