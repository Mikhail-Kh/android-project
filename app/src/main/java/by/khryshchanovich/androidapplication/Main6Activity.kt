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

            var flag = false
            CoroutineScope(Dispatchers.IO).launch {

                var counter1 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView24.text = counter1.toString()
                    }
                    delay(1000)
                    if (counter1 > 51) {
                        flag = true
                        break
                    }
                    counter1 += counter1
                }
            }
            /*if (flag) {
                textView27.text = "$flag"
            }*/


            /*CoroutineScope(Dispatchers.IO).launch {
                var counter2 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView23.text = counter2.toString()
                    }
                    delay(1000)
                    if (counter2 > 51) break
                    counter2 += counter2
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                var counter3 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView22.text = counter3.toString()
                    }
                    delay(1000)
                    if (counter3 > 51) break
                    counter3 += counter3
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                var counter4 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView21.text = counter4.toString()
                    }
                    delay(1000)
                    if (counter4 > 51) break
                    counter4 += counter4
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                var counter5 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView20.text = counter5.toString()
                    }
                    delay(1000)
                    if (counter5 > 51) break
                    counter5 += counter5
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                var counter6 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView19.text = counter6.toString()
                    }
                    delay(1000)
                    if (counter6 > 51) break
                    counter6 += counter6
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                var counter7 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView18.text = counter7.toString()
                    }
                    delay(1000)
                    if (counter7 > 51) break
                    counter7 += counter7
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                var counter8 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView17.text = counter8.toString()
                    }
                    delay(1000)
                    if (counter8 > 51) break
                    counter8 += counter8
                }
            }
            CoroutineScope(Dispatchers.IO).launch {
                var counter9 = (1..10).random()
                while (true) {
                    withContext(Dispatchers.Main) {
                        textView16.text = counter9.toString()
                    }
                    delay(1000)
                    if (counter9 > 51) break
                    counter9 += counter9
                }
            }*/


        }
    }
}