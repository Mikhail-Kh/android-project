package by.khryshchanovich.androidapplication.fibonacci_numbers.util

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FibonacciNumbersTest {

    private val fib = FibonacciNumbers.getFibonacci()

    @Test
    fun checkSize_isEqual_10() {
        val res = fib.size
        assertThat(res).isEqualTo(10)
    }

    @Test
    fun checkSize_isNotEqual_11() {
        val res = fib.size
        assertThat(res).isNotEqualTo(11)
    }

    @Test
    fun checkSize_isNotEqual_1() {
        val res = fib.size
        assertThat(res).isNotEqualTo(1)
    }

    @Test
    fun checkIndex2_isEqual_2() {
        val res = fib[2]
        assertThat(res).isEqualTo(2)
    }

    @Test
    fun checkIndex4_isEqual_5() {
        val res = fib[4]
        assertThat(res).isEqualTo(5)
    }

    @Test
    fun checkIndex9_isEqual_55() {
        val res = fib[9]
        assertThat(res).isEqualTo(55)
    }

    @Test
    fun checkNumber_isEqual_34() {
        val res = fib.contains(34)
        assertThat(res).isTrue()
    }
}