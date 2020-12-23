package by.khryshchanovich.androidapplication.rxjava.networking

import by.khryshchanovich.androidapplication.rxjava.dto.SummaryResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CovidApi {

    @GET("summary")
    fun getAll(): Single<SummaryResponse>
}