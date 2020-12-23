package by.khryshchanovich.androidapplication.rxjava.dto

import com.google.gson.annotations.SerializedName

data class SummaryResponse(
    @SerializedName("Countries")
    val countries: List<CountryResponse?>? = null,
    @SerializedName("Date")
    val date: String? = null,
    @SerializedName("Global")
    val global: Global? = null
)

data class CountryResponse(
    var flagUrl: String? = null,
    @SerializedName("Country")
    val country: String? = null,
    @SerializedName("CountryCode")
    val countryCode: String? = null,
    @SerializedName("Date")
    val date: String? = null,
    @SerializedName("NewConfirmed")
    val newConfirmed: Int? = null,
    @SerializedName("NewDeaths")
    val newDeaths: Int? = null,
    @SerializedName("NewRecovered")
    val newRecovered: Int? = null,
    @SerializedName("Slug")
    val slug: String? = null,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int? = null,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int? = null,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int? = null
)

data class Global(
    @SerializedName("NewConfirmed")
    val newConfirmed: Int? = null,
    @SerializedName("NewDeaths")
    val newDeaths: Int? = null,
    @SerializedName("NewRecovered")
    val newRecovered: Int? = null,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: Int? = null,
    @SerializedName("TotalDeaths")
    val totalDeaths: Int? = null,
    @SerializedName("TotalRecovered")
    val totalRecovered: Int? = null
)