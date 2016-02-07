package com.github.marcospereira

import java.io.File

/**
 * Created by francois on 2016-02-05.
 */

abstract class Day() {
    val file = File("src/main/resources/${javaClass.simpleName.toLowerCase()}.txt")

    abstract fun part1(): Any
    abstract fun part2(): Any
}