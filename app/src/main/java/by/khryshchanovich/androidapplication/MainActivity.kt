package by.khryshchanovich.androidapplication

import android.content.Intent  // подключаем класс Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.khryshchanovich.androidapplication.mothers_day.MainStartActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onStart() {
        super.onStart()
    }

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
    }
}