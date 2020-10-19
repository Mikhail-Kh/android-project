package by.khryshchanovich.androidapplication

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main6.*

class Main6Activity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val competitionViewModel = ViewModelProvider(this).get(CompetitionViewModel::class.java)
        competitionViewModel.counter1.observe(this, Observer { newCounter1 ->
            textView24.text = newCounter1.toString()})
        competitionViewModel.counter2.observe(this, Observer { newCounter2 ->
            textView23.text = newCounter2.toString()})
        competitionViewModel.counter3.observe(this, Observer { newCounter3 ->
            textView22.text = newCounter3.toString()})
        competitionViewModel.counter4.observe(this, Observer { newCounter4 ->
            textView21.text = newCounter4.toString()})
        competitionViewModel.counter5.observe(this, Observer { newCounter5 ->
            textView20.text = newCounter5.toString()})
        competitionViewModel.counter6.observe(this, Observer { newCounter6 ->
            textView19.text = newCounter6.toString()})
        competitionViewModel.counter7.observe(this, Observer { newCounter7 ->
            textView18.text = newCounter7.toString()})
        competitionViewModel.counter8.observe(this, Observer { newCounter8 ->
            textView17.text = newCounter8.toString()})
        competitionViewModel.counter9.observe(this, Observer { newCounter9 ->
            textView16.text = newCounter9.toString()})
        competitionViewModel.champion.observe(this, Observer {regionChampion ->
            textView27.text = regionChampion.toString()})
        competitionViewModel.colorBackground1.observe(this, Observer {regionColorBackground1 ->
            textView9.setBackgroundColor(regionColorBackground1)})
        competitionViewModel.colorBackground2.observe(this, Observer {regionColorBackground2 ->
            textView.setBackgroundColor(regionColorBackground2)})
        competitionViewModel.colorBackground3.observe(this, Observer {regionColorBackground3 ->
            textView2.setBackgroundColor(regionColorBackground3)})

        buttonStart.setOnClickListener {
            competitionViewModel.startCompetition()
        }
    }
}