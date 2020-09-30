package by.khryshchanovich.androidapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        buttonFlags.setOnClickListener {
            val myIntent = Intent(this, Main4Activity::class.java)
            startActivity(myIntent)
        }

        buttonAnimation.setOnClickListener {
            val myIntent = Intent(this, Main5Activity::class.java)
            startActivity(myIntent)
        }
    }
}