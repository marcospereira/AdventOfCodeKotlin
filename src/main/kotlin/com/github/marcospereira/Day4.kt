package com.github.marcospereira

import org.apache.commons.codec.digest.DigestUtils

/**
 * ## Day 4: The Ideal Stocking Stuffer
 *
 * Santa needs help mining some AdventCoins (very similar to bitcoins) to use
 * as gifts for all the economically forward-thinking little girls and boys.
 */
class Day4(val input: String) {

    fun md5(number: Int) = DigestUtils.md5Hex(input + number)

    /**
     * To do this, he needs to find MD5 hashes which, in hexadecimal, start with
     * at least five zeroes. The input to the MD5 hash is some secret key (your
     * puzzle input, given below) followed by a number in decimal. To mine
     * AdventCoins, you must find Santa the lowest positive number (no leading
     * zeroes: `1`, `2`, `3`, ...) that produces such a hash.
     *
     * For example:
     *
     *     - If your secret key is `abcdef`, the answer is `609043`, because the MD5
     *       hash of `abcdef609043` starts with five zeroes (`000001dbbfa...`), and it
     *       is the lowest such number to do so.
     *     - If your secret key is `pqrstuv`, the lowest number it combines with to
     *       make an MD5 hash starting with five zeroes is `1048970`; that is, the MD5
     *       hash of `pqrstuv1048970` looks like `000006136ef...`.
     */
    fun startsWithFiveZeroes() = startingWith("00000")

    /**
     * Now find one that starts with **six zeroes**.
     */
    fun startsWithSixZeroes() = startingWith("000000")

    private fun startingWith(s: String) = generateSequence(0) { it + 1 }.find { md5(it).startsWith(s) }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val day4 = Day4("bgvyzdsv")
            println(day4.startsWithFiveZeroes())
            println(day4.startsWithSixZeroes())
        }
    }
}
