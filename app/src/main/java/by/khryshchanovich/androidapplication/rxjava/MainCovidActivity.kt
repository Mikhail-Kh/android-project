package by.khryshchanovich.androidapplication.rxjava

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import by.khryshchanovich.androidapplication.R
import by.khryshchanovich.androidapplication.rxjava.adapter.SummaryAdapter
import by.khryshchanovich.androidapplication.rxjava.mapper.SummaryMapper
import by.khryshchanovich.androidapplication.rxjava.retrofit.RetrofitFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main_covid.*

class MainCovidActivity : AppCompatActivity() {

    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_covid)

        val api = RetrofitFactory().provideApi()
        val summaryAdapter = SummaryAdapter()

        summary_recycler_view.apply {
            adapter = summaryAdapter
            layoutManager = LinearLayoutManager(this@MainCovidActivity)
        }

        compositeDisposable = CompositeDisposable()

        val summaryDisposable = api.getAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { listOfResponse ->
                val list = listOfResponse.countries?.map {
                    SummaryMapper.map(it)
                }
                summaryAdapter.updateList(list)
            }
        compositeDisposable.add(summaryDisposable)
    }

    override fun onStop() {
        compositeDisposable.dispose()
        super.onStop()
    }
}