package by.khryshchanovich.androidapplication.fibonacci_numbers.util

object FibonacciNumbers {

    fun getFibonacci(): ArrayList<Int> {
        var numberOne = 1
        var numberTwo = 1
        val result = ArrayList<Int>()
        result.add(numberOne)
        result.add(numberTwo)

        for (i in 3..10) {
            val number = numberOne + numberTwo
            numberOne = numberTwo
            numberTwo = number
            result.add(number)
        }
        return result
    }
}