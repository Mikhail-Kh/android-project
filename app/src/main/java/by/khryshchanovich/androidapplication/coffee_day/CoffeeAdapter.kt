package by.khryshchanovich.androidapplication.coffee_day

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.khryshchanovich.androidapplication.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_coffee.view.*

class CoffeeAdapter(val coffeeSet: List<Coffee>) :
    RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {

    class CoffeeViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_coffee, parent, false)
        return CoffeeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return coffeeSet.size
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.itemView.coffeeName.text = coffeeSet[position].nameCoffee
        holder.itemView.coffeePrice.text = coffeeSet[position].priceCoffee.toString()
        Glide.with(holder.itemView.context).load(coffeeSet[position].urlCoffee)
            .into(holder.itemView.photoView)
    }
}