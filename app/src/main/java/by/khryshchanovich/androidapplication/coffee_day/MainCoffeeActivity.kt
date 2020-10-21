package by.khryshchanovich.androidapplication.coffee_day

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.khryshchanovich.androidapplication.R

class MainCoffeeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coffee)
    }
}