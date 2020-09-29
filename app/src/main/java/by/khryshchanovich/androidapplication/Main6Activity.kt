package by.khryshchanovich.androidapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main6.*
import kotlinx.coroutines.*

class Main6Activity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        buttonStart.setOnClickListener {
            var counter = 0
            runBlocking {

                launch {
                    while (counter != 1) {
                        delay(1000)
                        textView24.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 2) {
                        delay(1000)
                        textView23.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 3) {
                        delay(1000)
                        textView22.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 4) {
                        delay(1000)
                        textView21.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 5) {
                        delay(1000)
                        textView20.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 6) {
                        delay(1000)
                        textView19.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 7) {
                        delay(1000)
                        textView18.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 8) {
                        delay(1000)
                        textView17.text = counter.toString()
                        counter++
                    }
                }
                launch {
                    while (counter != 9) {
                        delay(1000)
                        textView16.text = counter.toString()
                        counter++
                    }
                }

            }
        }
    }
}