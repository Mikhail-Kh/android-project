package by.khryshchanovich.androidapplication.fibonacci_numbers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.fibonacci_numbers.util.FibonacciNumbers

class MainFibonacciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fibonacci)

        val fibonacci = findViewById<TextView>(R.id.fibonacci_text_view)
        fibonacci.text = FibonacciNumbers.getFibonacci().toString()
    }
}