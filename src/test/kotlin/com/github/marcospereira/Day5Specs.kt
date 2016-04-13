package com.github.marcospereira

import org.jetbrains.spek.api.*
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class Day5Specs : Spek() {
    init {
        given("Word") {
            listOf("aei", "xazegov", "aeiouaeiouaeiou").forEach { input ->
                on("check vowels for $input") {
                    it("contains three or more vowels", { assertTrue(input.containsAtLeastThreeVowels()) })
                }
            }
            listOf("xx", "acbdde", "aaddccbb").forEach { input ->
                on("check repeated letters for $input") {
                    it("contains at least one letter that appears twice in a row", { assertTrue(input.anyLetterAppearsTwiceInARow()) })
                }
            }
            listOf("abcdde", "aabbccdd", "aeiouddab", "aaacd", "aaapq", "aaaxy").forEach { input ->
                on("check bad parts for $input") {
                    it("contains bad parts", { assertTrue(input.containsBadParts()) })
                }
            }
            listOf("ugknbfddgicrmopn", "aaa").forEach { input ->
                on("check $input is nice") {
                    it("is naughty", { assertTrue(input.nice1())})
                }
            }
            listOf("jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb").forEach { input ->
                on("check $input is naughty") {
                    it("is naughty", { assertFalse(input.nice1())})
                }
            }
        }
    }
}