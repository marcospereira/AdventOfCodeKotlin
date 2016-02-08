package com.github.marcospereira

import com.github.marcospereira.day8.Day8

/**
 * Created by francois on 2016-02-07.
 */
class DayRunner {
    companion object {
        val days = listOf(
                //                Day1(),
                //                Day2(),
                //                Day3(),
                //                Day4(), //slow
                //                Day5(),
                //                Day6(),
                //                Day7(),
                Day8()
        )

        @JvmStatic
        fun main(args: Array<String>) {
            days.forEach { it.run() }
        }
    }
}