package by.khryshchanovich.androidapplication.weather_widget.retrofit

import by.khryshchanovich.androidapplication.weather_widget.networking.WeatherApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private const val BASE_URL = "https://api.openweathermap.org/"

class RetrofitFactory {
    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(
            object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain
                        .request()
                        .newBuilder()
                        .build()
                    return chain.proceed(request)
                }
            })

    fun getRetrofit(): WeatherApi {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(client.build())
            .build()
        return retrofit.create()
    }
}