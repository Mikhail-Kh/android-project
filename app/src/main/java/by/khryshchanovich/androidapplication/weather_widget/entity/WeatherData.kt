package by.khryshchanovich.androidapplication.weather_widget.entity

data class WeatherData(
    val dt: Int,
    val city: String,
    val temperature: Double,
    val icon: String,
    val description: String
)