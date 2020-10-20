package by.khryshchanovich.androidapplication.coffee_day

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.khryshchanovich.androidapplication.R
import kotlinx.android.synthetic.main.fragment_second.*

class FragmentSecond : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val adapter = CoffeeAdapter(Collection.coffeeCollection)
        coffeeRecycler.adapter = adapter
        coffeeRecycler.layoutManager = LinearLayoutManager(context)
        coffeeRecycler.hasFixedSize()
    }
}