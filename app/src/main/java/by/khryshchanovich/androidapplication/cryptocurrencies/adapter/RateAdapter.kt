package by.khryshchanovich.androidapplication.cryptocurrencies.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.cryptocurrencies.entity.Rates
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cryptocurrancies.view.*
import okhttp3.internal.format

private const val URL_IMAGE = "https://s2.coinmarketcap.com/static/img/coins/64x64/"

class RateAdapter : RecyclerView.Adapter<RateAdapter.RateVH>() {
    private var listRates = ArrayList<Rates>()

    fun updateList(list: List<Rates>?) {
        listRates = list as ArrayList<Rates>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cryptocurrancies, parent, false)
        return RateVH(view)
    }

    override fun getItemCount() = listRates.size

    override fun onBindViewHolder(holder: RateVH, position: Int) {
        holder.bind(listRates[position])
    }

    class RateVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @SuppressLint("SetTextI18n")
        fun bind(rates: Rates) {
            with(itemView) {
                name_text_view.text = rates.name
                symbol_text_view.text = "(" + rates.symbol + ")"
                if (rates.price < 1) {
                    price_text_view.text = "$" + format("%.5f", rates.price)
                } else {
                    price_text_view.text = "$" + format("%.2f", rates.price)
                }
                if (rates.percentChange1h < 0) {
                    percentChange1h_text_view.text =
                        "1 hour: " + format("%.2f", rates.percentChange1h) + "%"
                    percentChange1h_text_view.setTextColor(Color.RED)
                } else {
                    percentChange1h_text_view.text =
                        "1 hour: " + "%.2f".format(rates.percentChange1h) + "%"
                    percentChange1h_text_view.setTextColor(Color.GREEN)
                }
                Picasso.get().load(URL_IMAGE + rates.id + ".png").into(cryptocurrencies_image_view)
            }
        }
    }
}