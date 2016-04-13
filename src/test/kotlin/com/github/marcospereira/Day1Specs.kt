package com.github.marcospereira

import org.jetbrains.spek.api.*
import kotlin.test.assertEquals

class Day1Specs : Spek() {
    init {
        given("We want to know which floor we will be at the end") {
            listOf(
                    Pair("(())", 0),
                    Pair("()()", 0),
                    Pair("(((", 3),
                    Pair("(()(()(", 3),
                    Pair("))(((((", 3),
                    Pair("())", -1),
                    Pair("))(", -1),
                    Pair(")))", -3),
                    Pair(")())())", -3)
            ).forEach { pair ->
                // replace to keep spek report readable
                on("input ${pair.first.replace('(', 'u').replace(')', 'd')}") {
                    val day1 = Day1()
                    it("should go to floor ${pair.second}", { assertEquals(pair.second, day1.part1()) })
                }
            }
        }
        given("We want to know when we reach basement") {
            listOf(
                    Pair(")", 1),
                    Pair("()())", 5)
            ).forEach { pair ->
                on("input ${pair.first.replace('(', 'u').replace(')', 'd')}") {
                    val day1 = Day1()
                    it("should reach basement at instruction ${pair.second}",  { assertEquals(pair.second, day1.part2()) })
                }
            }
        }
    }
}