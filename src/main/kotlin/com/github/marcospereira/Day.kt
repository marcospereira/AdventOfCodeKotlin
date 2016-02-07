package com.github.marcospereira

import java.io.File

abstract class Day() {

    val file = File("src/main/resources/${javaClass.simpleName.toLowerCase()}.txt")

    abstract fun part1(): Any?
    abstract fun part2(): Any?

    fun run() = println("""
        Class: ${javaClass.simpleName}
            Part 1: ${runSafely { part1() }}
            Part 2: ${runSafely { part2() }}"""
    )

    private fun runSafely(part: () -> Any?): Any? {
        try {
            return part()
        } catch (e: UnsupportedOperationException) {
            return "Not implemented"
        }
    }
}