package by.khryshchanovich.androidapplication.book_database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import by.khryshchanovich.androidapplication.book_database.dao.BookDao
import by.khryshchanovich.androidapplication.book_database.entity.Book

@Database(entities = [Book::class], version = 1)
abstract class BookDb : RoomDatabase() {

    abstract fun bookDao(): BookDao
}

object db {
    fun getDb(ctx: Context) = Room.databaseBuilder(ctx, BookDb::class.java, "BookDataBase").build()
}