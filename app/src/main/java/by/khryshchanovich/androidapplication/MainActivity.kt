package by.khryshchanovich.androidapplication

import android.content.Intent  // подключаем класс Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import by.khryshchanovich.androidapplication.book_database.MainDatabaseActivity
import by.khryshchanovich.androidapplication.coffee_day.MainCoffeeActivity
import by.khryshchanovich.androidapplication.cryptocurrencies.MainNetworkingActivity
import by.khryshchanovich.androidapplication.mothers_day.MainStartActivity
import by.khryshchanovich.androidapplication.user_registration.MainRegistrationActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

<<<<<<< HEAD
    override fun onStart() {
        super.onStart()
    }

=======
>>>>>>> feature_load_picture
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val myIntent = Intent(this, Main2Activity::class.java)
            startActivity(myIntent)
        }

        button2.setOnClickListener {
            val myIntent = Intent(this, Main3Activity::class.java)
            startActivity(myIntent)
        }

        button3.setOnClickListener {
            val myIntent = Intent(this, Main6Activity::class.java)
            startActivity(myIntent)
        }

        button_mothers_day.setOnClickListener {
            startActivity(Intent(this, MainStartActivity::class.java))
        }

        button_coffee_day.setOnClickListener {
            startActivity(Intent(this, MainCoffeeActivity::class.java))
        }

        button_user_registration.setOnClickListener {
            startActivity(Intent(this, MainRegistrationActivity::class.java))
        }

        val databaseClickButton = findViewById<Button>(R.id.database_button)
        databaseClickButton.setOnClickListener {
            startActivity(Intent(this, MainDatabaseActivity::class.java))
        }

        val networkingButton = findViewById<Button>(R.id.networking_button)
        networkingButton.setOnClickListener {
            startActivity(Intent(this, MainNetworkingActivity::class.java))
        }
    }
}