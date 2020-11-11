package by.khryshchanovich.androidapplication.book_database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import by.khryshchanovich.androidapplication.book_database.entity.Book

@Dao
interface BookDao {

    @Insert
    suspend fun addBook(book: Book)

    @Query("SELECT * FROM books_table")
    suspend fun getAllBooks(): List<Book>
}