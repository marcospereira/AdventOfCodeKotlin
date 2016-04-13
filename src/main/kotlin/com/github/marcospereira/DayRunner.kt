package com.github.marcospereira

class DayRunner {
    companion object {
        val days = listOf(
                Day1(),
                Day2(),
                Day3(),
                Day4(),
                Day5(),
                Day6()
        )

        @JvmStatic
        fun main(args: Array<String>) {
            days.forEach { it.run() }
        }
    }
}