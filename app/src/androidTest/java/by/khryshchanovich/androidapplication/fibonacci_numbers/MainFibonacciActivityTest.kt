package by.khryshchanovich.androidapplication.fibonacci_numbers

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import by.khryshchanovich.androidapplication.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainFibonacciActivityTest {

    private lateinit var activityScenario: ActivityScenario<MainFibonacciActivity>

    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(MainFibonacciActivity::class.java)
    }

    @Test
    fun fibonacciNumbersIsVisible_returnsTrue() {
        onView(withId(R.id.fibonacci_text_view)).check(matches(isDisplayed()))
    }

    @Test
    fun fibonacciNumbersIsCorrect_returnsTrue() {
        onView(withId(R.id.fibonacci_text_view)).check(matches(withText("[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]")))
    }
}