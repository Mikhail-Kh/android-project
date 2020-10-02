package by.khryshchanovich.androidapplication

import android.graphics.Color
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CompetitionViewModel : ViewModel() {
    var counter1 = MutableLiveData(0)
    var counter2 = MutableLiveData(0)
    var counter3 = MutableLiveData(0)
    var counter4 = MutableLiveData(0)
    var counter5 = MutableLiveData(0)
    var counter6 = MutableLiveData(0)
    var counter7 = MutableLiveData(0)
    var counter8 = MutableLiveData(0)
    var counter9 = MutableLiveData(0)
    var champion = MutableLiveData<String>()
    var colorBackground1 = MutableLiveData<Int>()
    var colorBackground2 = MutableLiveData<Int>()
    var colorBackground3 = MutableLiveData<Int>()

    @RequiresApi(Build.VERSION_CODES.O)
    fun startCompetition() {
        var num1 = counter1.value
        var num2 = counter2.value
        var num3 = counter3.value
        var num4 = counter4.value
        var num5 = counter5.value
        var num6 = counter6.value
        var num7 = counter7.value
        var num8 = counter8.value
        var num9 = counter9.value
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(500)
                counter1.postValue(num1)
                counter2.postValue(num2)
                counter3.postValue(num3)
                counter4.postValue(num4)
                counter5.postValue(num5)
                counter6.postValue(num6)
                counter7.postValue(num7)
                counter8.postValue(num8)
                counter9.postValue(num9)
                if (num1!! >= 100 && num2!! >= 100 && num3!! >= 100) {
                    champion.postValue("Гродненская область")
                    colorBackground1.postValue(Color.YELLOW)
                    break
                } else if (num4!! >= 100 && num5!! >= 100 && num6!! >= 100) {
                    champion.postValue("Брестская область")
                    colorBackground2.postValue(Color.YELLOW)
                    break
                } else if (num7!! >= 100 && num8!! >= 100 && num9!! >= 100) {
                    champion.postValue("Витебская область")
                    colorBackground3.postValue(Color.YELLOW)
                    break
                }
                num1 = (1..5).random().plus(num1!!)
                num2 = (1..5).random().plus(num2!!)
                num3 = (1..5).random().plus(num3!!)
                num4 = (1..5).random().plus(num4!!)
                num5 = (1..5).random().plus(num5!!)
                num6 = (1..5).random().plus(num6!!)
                num7 = (1..5).random().plus(num7!!)
                num8 = (1..5).random().plus(num8!!)
                num9 = (1..5).random().plus(num9!!)
            }
        }
    }
}