package by.khryshchanovich.androidapplication.mothers_day

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.khryshchanovich.androidapplication.R
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_main_congratulation.*

class MainCongratulationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_congratulation)

        YoYo.with(Techniques.ZoomInUp)
            .repeat(0)
            .duration(2000)
            .playOn(dear_mother_text)

        YoYo.with(Techniques.ZoomInUp)
            .repeat(0)
            .duration(5000)
            .playOn(congratulate_text)

        YoYo.with(Techniques.ZoomInUp)
            .repeat(0)
            .duration(8000)
            .playOn(wish_text)

        YoYo.with(Techniques.ZoomInRight)
            .repeat(0)
            .duration(10000)
            .playOn(flowers_image_view)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.enter_back, R.anim.exit_back)
    }
}