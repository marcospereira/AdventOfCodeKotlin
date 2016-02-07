package com.github.marcospereira

import java.io.File

abstract class Day() {
    val file = File("src/main/resources/${javaClass.simpleName.toLowerCase()}.txt")

    abstract fun part1(): Any?
    abstract fun part2(): Any?

    fun run() {
        println("Part 1: ${part1()}")
        println("Part 2: ${part2()}")
    }
}