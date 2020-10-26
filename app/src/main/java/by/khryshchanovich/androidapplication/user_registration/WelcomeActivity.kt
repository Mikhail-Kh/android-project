package by.khryshchanovich.androidapplication.user_registration

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.khryshchanovich.androidapplication.R
import kotlinx.android.synthetic.main.activity_welcome.*

private const val KEY_NAME = "username"

class WelcomeActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val username = intent.getStringExtra(KEY_NAME)
        welcome_text_view.text = "Welcome $username!"
    }
}