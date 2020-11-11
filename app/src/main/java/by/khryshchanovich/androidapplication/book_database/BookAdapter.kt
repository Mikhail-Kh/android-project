package by.khryshchanovich.androidapplication.book_database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.book_database.entity.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BookAdapter(val bookSet: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bookSet.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.itemView.bookAuthor.text = bookSet[position].author
        holder.itemView.bookTitle.text = bookSet[position].title
        holder.itemView.bookYear.text = bookSet[position].year.toString()
    }
}