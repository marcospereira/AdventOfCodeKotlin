package com.github.marcospereira.day8

import com.github.marcospereira.Day

/**
 * Created by francois on 2016-02-07.
 */
class Day8 : Day() {

    override fun part1(): Any? = file.readLines().sumBy {
        val memoryString = it.slice(1..it.length - 2)
                .replace("\\\\", " ")
                .replace("\\\"", " ")
                .replace(Regex("\\\\x[0-9a-fA-F]{2}"), " ")

        return@sumBy it.length - memoryString.length
    }

    override fun part2(): Any? {
        throw UnsupportedOperationException()
    }
}