package by.khryshchanovich.androidapplication.cryptocurrencies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.cryptocurrencies.adapter.RateAdapter
import by.khryshchanovich.androidapplication.cryptocurrencies.dto.RatesResponse
import by.khryshchanovich.androidapplication.cryptocurrencies.entity.Rates
import by.khryshchanovich.androidapplication.cryptocurrencies.mappers.RatesMapper
import by.khryshchanovich.androidapplication.cryptocurrencies.networking.NBApi
import by.khryshchanovich.androidapplication.cryptocurrencies.retrofit.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main_networking.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainNetworkingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_networking)

        val retrofit: NBApi = RetrofitFactory().getRetrofit()
        val rateAdapter = RateAdapter()

        cryptocurrencies_recycler_view.apply {
            adapter = rateAdapter
            layoutManager = LinearLayoutManager(this@MainNetworkingActivity)
        }

        CoroutineScope(Dispatchers.IO).launch {
            val response : Response<RatesResponse> = retrofit.getRates().await()
            if (response.isSuccessful) {
                val ratesResponse: RatesResponse? = response.body()
                val rates: List<Rates>? = ratesResponse?.data?.map {
                    RatesMapper().map(it)
                }
                withContext(Dispatchers.Main) {
                    rateAdapter.updateList(rates)
                }
            } else {
                Toast.makeText(this@MainNetworkingActivity, "ERROR", Toast.LENGTH_SHORT).show()
            }
        }
    }
}