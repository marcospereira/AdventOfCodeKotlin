package com.github.marcospereira

import org.jetbrains.spek.api.*
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class Day5Specs : Spek() {
    init {
        given("Word") {
            listOf("aei", "xazegov", "aeiouaeiouaeiou").forEach { input ->
                on("check vowels for $input") {
                    val word = Word(input)
                    it("contains three or more vowels", { assertTrue(word.containsAtLeastThreeVowels()) })
                }
            }
            listOf("xx", "acbdde", "aaddccbb").forEach { input ->
                on("check repeated letters for $input") {
                    val word = Word(input)
                    it("contains at least one letter that appears twice in a row", { assertTrue(word.anyLetterAppearsTwiceInARow()) })
                }
            }
            listOf("abcdde", "aabbccdd", "aeiouddab", "aaacd", "aaapq", "aaaxy").forEach { input ->
                on("check bad parts for $input") {
                    val word = Word(input)
                    it("contains bad parts", { assertTrue(word.containsBadParts()) })
                }
            }
            listOf("ugknbfddgicrmopn", "aaa").forEach { input ->
                on("check $input is nice") {
                    val word = Word(input)
                    it("is naughty", { assertTrue(word.nice())})
                }
            }
            listOf("jchzalrnumimnmhp", "haegwjzuvuyypxyu", "dvszwmarrgswjxmb").forEach { input ->
                on("check $input is naughty") {
                    val word = Word(input)
                    it("is naughty", { assertFalse(word.nice())})
                }
            }
        }
    }
}