package com.github.marcospereira

/**
 * Created by francois on 2016-02-07.
 */
class DayRunner {
    companion object {
        val days = listOf(
                Day1(),
                Day2(),
                Day3(),
                //                Day4(), //slow
                Day5(),
                Day6())

        @JvmStatic
        fun main(args: Array<String>) {
            days.forEach { it.run() }
        }
    }
}