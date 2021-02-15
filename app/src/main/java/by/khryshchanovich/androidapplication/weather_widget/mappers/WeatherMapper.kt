package by.khryshchanovich.androidapplication.weather_widget.mappers

import by.khryshchanovich.androidapplication.weather_widget.dto.WeatherResponse
import by.khryshchanovich.androidapplication.weather_widget.entity.WeatherData

class WeatherMapper {
    fun map(from: WeatherResponse?): WeatherData {

        return WeatherData(
            dt = from?.dt ?: 0,
            city = from?.name.orEmpty(),
            temperature = from?.main?.temp ?: 0.0,
            description = from?.weather?.get(0)?.main.orEmpty(),
            icon = from?.weather?.get(0)?.icon.orEmpty()
        )
    }
}