package by.khryshchanovich.androidapplication.user_registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import by.khryshchanovich.androidapplication.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main_registration.*

private const val KEY_NAME = "username"

class MainRegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_registration)

        usernameEditText.addTextChangedListener {
            if (it.isNullOrEmpty()) {
                usernameTextField.error = getString(R.string.error)
            } else {
                usernameTextField.error = null
            }
        }

        passwordEditText.addTextChangedListener {
            if (passwordEditText.length() < 8) {
                passwordTextField.error = getString(R.string.password_is_8_characters)
            } else {
                passwordTextField.error = null
            }
        }

        registration_button.setOnClickListener {
            if (usernameEditText.text.toString().isNotEmpty() && passwordEditText.length() >= 8) {
                MaterialAlertDialogBuilder(this)
                    .setTitle(usernameEditText.text.toString())
                    .setMessage(getString(R.string.you_are_registered))
                    .setNeutralButton("Ok") { _, _ ->
                    }
                    .setPositiveButton("Sign in") { _, _ ->
                        val intent = Intent(this, WelcomeActivity::class.java)
                        intent.putExtra(KEY_NAME, usernameEditText.text.toString())
                        startActivity(intent)
                    }
                    .setIcon(R.drawable.login)
                    .show()
            } else {
                Toast.makeText(this, "Fill in all the fields correctly!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}