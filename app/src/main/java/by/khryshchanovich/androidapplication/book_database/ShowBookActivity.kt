package by.khryshchanovich.androidapplication.book_database

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.book_database.dao.BookDao
import by.khryshchanovich.androidapplication.book_database.database.db
import by.khryshchanovich.androidapplication.book_database.entity.Book
import by.khryshchanovich.androidapplication.book_database.utils.launchForResult
import by.khryshchanovich.androidapplication.book_database.utils.launchIo
import by.khryshchanovich.androidapplication.book_database.utils.launchUi
import kotlinx.android.synthetic.main.activity_show_book.*

class ShowBookActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_book)

        val db: BookDao = db.getDb(this).bookDao()

        launchIo {
            val result: List<Book> = db.getAllBooks()

            launchForResult {
                launchUi {
                    val adapter = BookAdapter(result)
                    bookRecycler.adapter = adapter
                    bookRecycler.layoutManager = LinearLayoutManager(this)
                    bookRecycler.hasFixedSize()
                }
            }

            bookSearch.addTextChangedListener {
                bookRecycler.adapter = BookAdapter(result.filter { bookTitle ->
                    bookTitle.title.contains(bookSearch.text.toString(), true)
                })
            }
        }
    }
}