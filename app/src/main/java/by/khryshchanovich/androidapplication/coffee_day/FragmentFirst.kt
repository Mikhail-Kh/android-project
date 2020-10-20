package by.khryshchanovich.androidapplication.coffee_day

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import by.khryshchanovich.androidapplication.R
import kotlinx.android.synthetic.main.fragment_first.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentFirst.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentFirst : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentFirst.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentFirst().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}