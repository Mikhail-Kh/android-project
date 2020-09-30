package by.khryshchanovich.androidapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< HEAD

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
=======
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        buttonLoad.setOnClickListener {
            val url:String = editText.text.toString()
            Picasso.get().load(url).into(imageView)
        }
>>>>>>> feature_load_picture
    }
}