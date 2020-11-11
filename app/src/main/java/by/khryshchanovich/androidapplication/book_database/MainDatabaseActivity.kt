package by.khryshchanovich.androidapplication.book_database

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.book_database.dao.BookDao
import by.khryshchanovich.androidapplication.book_database.database.db
import by.khryshchanovich.androidapplication.book_database.entity.Book
import by.khryshchanovich.androidapplication.book_database.utils.launchIo
import kotlinx.android.synthetic.main.activity_main_database.*

class MainDatabaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_database)

        val db: BookDao = db.getDb(this).bookDao()

        val addBookButton = findViewById<Button>(R.id.add_book_button)
        addBookButton.setOnClickListener {
            if ((author_edit_text.text.toString() == "")
                or (title_edit_text.text.toString() == "")
                or (year_edit_text.text.toString() == "")
            ) {
                Toast.makeText(this, "Enter author, title and year!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }
            val author = author_edit_text.text.toString()
            val title = title_edit_text.text.toString()
            val year = year_edit_text.text.toString().toInt()
            val book = Book(author, title, year)

            launchIo {
                db.addBook(book)
            }
            Toast.makeText(this, "A book added", Toast.LENGTH_SHORT).show()
            author_edit_text.text.clear()
            title_edit_text.text.clear()
            year_edit_text.text.clear()
        }

        val seeBookButton = findViewById<Button>(R.id.see_book_button)
        seeBookButton.setOnClickListener {

            startActivity(Intent(this, ShowBookActivity::class.java))
        }
    }
}