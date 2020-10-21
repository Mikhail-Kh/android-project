package by.khryshchanovich.androidapplication.coffee_day

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.khryshchanovich.androidapplication.R
import kotlinx.android.synthetic.main.fragment_first.*

class FragmentFirst : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_add_all_fields.setOnClickListener {
            if ((edit_kind_of_coffee.text.toString() == "")
                or (edit_price_of_coffee.text.toString() == "")
                or (edit_url_of_coffee.text.toString() == "")
            ) {
                Toast.makeText(context, "Enter kind of coffee, price and url!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            Collection.coffeeCollection.add(
                Coffee(
                    edit_kind_of_coffee.text.toString(),
                    edit_price_of_coffee.text.toString().toDouble(),
                    edit_url_of_coffee.text.toString()
                )
            )
            Toast.makeText(context, "Kind of coffee added", Toast.LENGTH_SHORT).show()
            edit_kind_of_coffee.text.clear()
            edit_price_of_coffee.text.clear()
            edit_url_of_coffee.text.clear()
        }
    }
}