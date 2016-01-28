package com.github.marcospereira

import org.jetbrains.spek.api.*
import kotlin.test.assertEquals

class Day2Specs : Spek() {
    init {
        given("A box 2x3x4") {
            val box = Box(2, 3, 4)
            on("box metrics") {
                it("surface should be equals to 52") {
                    assertEquals(52, box.surface())
                }
                it("required paper should be equals 58") {
                    assertEquals(58, box.requiredWrappingPaper())
                }
            }
        }
    }
}