package by.khryshchanovich.androidapplication.book_database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class Book(
    @ColumnInfo(name = "book_author")
    val author: String,
    @ColumnInfo(name = "book_title")
    val title: String,
    @ColumnInfo(name = "book_year")
    val year: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}