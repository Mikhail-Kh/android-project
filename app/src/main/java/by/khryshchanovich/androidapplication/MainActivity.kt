package by.khryshchanovich.androidapplication

import android.content.Intent  // подключаем класс Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}