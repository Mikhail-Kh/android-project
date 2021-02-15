package by.khryshchanovich.androidapplication.rxjava.mapper

import by.khryshchanovich.androidapplication.rxjava.dto.CountryResponse
import by.khryshchanovich.androidapplication.rxjava.entity.Country

object SummaryMapper {

    fun map(from: CountryResponse?): Country {

        return Country(
            flagUrl = from?.flagUrl.orEmpty(),
            country = from?.country.orEmpty(),
            countryCode = from?.countryCode.orEmpty(),
            date = from?.date.orEmpty(),
            totalConfirmed = from?.totalConfirmed ?: 0,
            totalDeaths = from?.totalDeaths ?: 0,
            totalRecovered = from?.totalRecovered ?: 0
        )
    }
}