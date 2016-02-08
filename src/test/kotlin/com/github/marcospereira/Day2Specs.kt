package com.github.marcospereira

import com.github.marcospereira.day2.Box
import org.jetbrains.spek.api.Spek
import kotlin.test.assertEquals

class Day2Specs : Spek() {
    init {
        given("Box metrics") {
            on("Box with l=2, w=3, h=4") {
                val box = Box(2, 3, 4)
                it("surface should be equals to 52", { assertEquals(52, box.surface()) })
                it("required paper should be equals 58", { assertEquals(58, box.requiredWrappingPaper()) })
                it("ribbon to wrap is 10", { assertEquals(10, box.ribbonToWrap()) })
                it("ribbon for the bow is 24", { assertEquals(24, box.ribbonForTheBow()) })
                it("required ribbon is 34", { assertEquals(34, box.requiredFeetOfRibbon()) })
            }
            on("Box with l=1, w=1, h=10") {
                val box = Box(1, 1, 10)
                it("surface should be equals to 52", { assertEquals(42, box.surface()) })
                it("required paper should be equals 58", { assertEquals(43, box.requiredWrappingPaper()) })
                it("ribbon to wrap is 4", { assertEquals(4, box.ribbonToWrap()) })
                it("ribbon for the bow is 10", { assertEquals(10, box.ribbonForTheBow()) })
                it("required ribbon is 14", { assertEquals(14, box.requiredFeetOfRibbon()) })
            }
        }
    }
}