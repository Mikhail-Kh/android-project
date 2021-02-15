package by.khryshchanovich.androidapplication.notification

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import by.khryshchanovich.androidapplication.R
import kotlinx.android.synthetic.main.activity_main_notification.*

class MainNotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_notification)

        val startButton = findViewById<Button>(R.id.start_button)
        val stopButton = findViewById<Button>(R.id.stop_button)
        val intent = Intent(this, MyForegroundService::class.java)

        startButton.setOnClickListener {
            val timer = object : CountDownTimer(10000, 1000) {

                @SuppressLint("SetTextI18n")
                override fun onFinish() {
                    startService(intent)
                }

                @SuppressLint("SetTextI18n")
                override fun onTick(millisUntilFinished: Long) {
                    timer_text_view.text = (millisUntilFinished / 1000).toString()
                }
            }
            timer.start()
        }

        stopButton.setOnClickListener {
            stopService(intent)
        }
    }
}