package com.github.marcospereira

import java.io.File

abstract class Day() {

    val file = File("src/main/resources/${javaClass.simpleName.toLowerCase()}.txt")

    abstract fun part1(): Any?
    abstract fun part2(): Any?

    fun run() = println("""
        Class: ${javaClass.simpleName}
            Part 1: ${runPart1()}
            Part 2: ${runPart2()}"""
    )

    private fun runPart1(): Any? {
        try {
            return part1()
        } catch (e: UnsupportedOperationException) {
            return "Not implemented"
        }
    }

    private fun runPart2(): Any? {
        try {
            return part2()
        } catch (e: UnsupportedOperationException) {
            return "Not implemented"
        }
    }
}