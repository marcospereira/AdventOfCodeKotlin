package com.github.marcospereira

val checkTwiceRule = Regex("(\\p{Alpha})\\1+")
val checkBadParts = Regex("ab|cd|pq|xy")

data class Word(val word: String) {
    fun containsAtLeastThreeVowels() = word.count { "aeiou".contains(it) } >= 3

    fun anyLetterAppearsTwiceInARow() = checkTwiceRule.containsMatchIn(word)

    fun containsBadParts() = checkBadParts.containsMatchIn(word)

    fun nice() = containsAtLeastThreeVowels() && anyLetterAppearsTwiceInARow() && !containsBadParts()
}

/**
 * ## Day 5: Doesn't He Have Intern-Elves For This?
 *
 * Santa needs help figuring out which strings in his text file are
 * naughty or nice.
 */
class Day5() : Day() {

    val words = file.readLines().map { Word(it) }

    /**
     * A nice string is one with all of the following properties:
     *
     *     - It contains at least three vowels (aeiou only), like aei,
     *       xazegov, or aeiouaeiouaeiou.
     *     - It contains at least one letter that appears twice in a row,
     *       like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
     *     - It does not contain the strings ab, cd, pq, or xy, even if they
     *       are part of one of the other requirements.
     *
     * For example:

     *     - `ugknbfddgicrmopn` is nice because it has at least three
     *       vowels (u...i...o...), a double letter (...dd...), and
     *       none of the disallowed substrings.
     *     - `aaa` is nice because it has at least three vowels and a
     *       double letter, even though the letters used by different
     *       rules overlap.
     *     - `jchzalrnumimnmhp` is naughty because it has no double letter.
     *     - `haegwjzuvuyypxyu` is naughty because it contains the string xy.
     *     - `dvszwmarrgswjxmb` is naughty because it contains only one vowel.
     *
     * How many strings are nice?
     */
    override fun part1() = words.filter { it.nice() }.size

    override fun part2(): Any {
        throw UnsupportedOperationException()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Day5().run()
        }
    }
}
