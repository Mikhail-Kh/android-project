package by.khryshchanovich.androidapplication.mothers_day

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.khryshchanovich.androidapplication.R
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main_start.*

class MainStartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_start)

        YoYo.with(Techniques.ZoomIn)
            .repeat(0)
            .duration(3000)
            .playOn(textViewCongratulation)

        YoYo.with(Techniques.ZoomIn)
            .repeat(0)
            .duration(3000)
            .playOn(textViewMothersDay)

        button_congratulate.setOnClickListener {
            startActivity(Intent(this, MainCongratulationActivity::class.java))
            overridePendingTransition(R.anim.enter, R.anim.exit)
        }
    }
}