package com.github.marcospereira

import java.io.File

/**
 * Created by francois on 2016-02-05.
 */

abstract class Day() {

    val file = File("src/main/resources/${javaClass.simpleName.toLowerCase()}.txt")

    abstract fun part1(): Any?
    abstract fun part2(): Any?

    fun run() {
        println(javaClass.simpleName)
        println("Part 1: ${runSafely { part1() }}")
        println("Part 2: ${runSafely { part2() }}")
        println("")
    }

    private fun runSafely(part: () -> Any?): Any? {
        try {
            return part()
        } catch (e: UnsupportedOperationException) {
            return "Not implemented"
        }
    }
}