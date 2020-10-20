package by.khryshchanovich.androidapplication.coffee_day

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.khryshchanovich.androidapplication.R
import kotlinx.android.synthetic.main.fragment_start.*

class FragmentStart : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        button_add_coffee.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStart_to_fragmentFirst)
        }
        button_see_coffee.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentStart_to_fragmentSecond)
        }
    }
}