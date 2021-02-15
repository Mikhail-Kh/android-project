package by.khryshchanovich.androidapplication.rxjava.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.rxjava.entity.Country
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_covid.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class SummaryAdapter : RecyclerView.Adapter<SummaryAdapter.SummaryVH>() {

    private var listSummary = ArrayList<Country>()

    fun updateList(list: List<Country>?) {
        listSummary = list as ArrayList<Country>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid, parent, false)
        return SummaryVH(view)
    }

    override fun getItemCount() = listSummary.size

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: SummaryVH, position: Int) {
        holder.bind(listSummary[position])
    }

    class SummaryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val formatter = SimpleDateFormat("HH:mm:ss dd-MM-yyyy", Locale.getDefault())

        @SuppressLint("SetTextI18n")
        fun bind(country: Country) {
            with(itemView) {
                val dateTime = formatter.format(parser.parse(country.date))
                country_text_view.text = country.country
                date_text_view.text = dateTime
                totalConfirmed_text_view.text =
                    "Total confirmed: " + country.totalConfirmed.toString()
                totalDeaths_text_view.text = "Total deaths: " + country.totalDeaths.toString()
                totalRecovered_text_view.text =
                    "Total recovered: " + country.totalRecovered.toString()
                Picasso.get().load(
                    "https://cdn.countryflags.com/thumbs/${country.country.replace(" ", "-")
                        .toLowerCase(
                            Locale.ROOT
                        )}/flag-400.png"
                ).into(flagUrl_text_view)
            }
        }
    }
}