package com.github.marcospereira

class DayRunner {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            listOf(
                    Day1(),
                    Day2(),
                    Day3(),
                    //                Day4(), //slow
                    Day5(),
                    Day6()
            ).forEach { it.run() }
        }
    }
}