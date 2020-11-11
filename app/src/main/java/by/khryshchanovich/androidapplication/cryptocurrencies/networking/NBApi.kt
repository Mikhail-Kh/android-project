package by.khryshchanovich.androidapplication.cryptocurrencies.networking

import by.khryshchanovich.androidapplication.cryptocurrencies.dto.RatesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface NBApi {

    @GET("v1/cryptocurrency/listings/latest")
    fun getRates(): Deferred<Response<RatesResponse>>
}