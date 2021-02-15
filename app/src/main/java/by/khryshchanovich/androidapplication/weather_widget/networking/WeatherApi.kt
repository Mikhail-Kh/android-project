package by.khryshchanovich.androidapplication.weather_widget.networking

import by.khryshchanovich.androidapplication.weather_widget.dto.WeatherResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_ID = "066684c224288ec83f079c8017eb1057"
const val UNITS = "metric"
const val CITY = "Minsk"

interface WeatherApi {
    @GET("/data/2.5/weather")
    fun getWeatherAsync(
        @Query("q")
        city: String = CITY,
        @Query("appid")
        appId: String = API_ID,
        @Query("units")
        units: String = UNITS
    ): Deferred<Response<WeatherResponse>>
}