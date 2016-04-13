package com.github.marcospereira

/**
 * ## Day 6: Probably a Fire Hazard
 *
 * Because your neighbors keep defeating you in the holiday house decorating
 * contest year after year, you've decided to deploy one million lights in a
 * 1000x1000 grid.
 *
 * Furthermore, because you've been especially nice this year, Santa has
 * mailed you instructions on how to display the ideal lighting configuration.
 */
class Day6() : Day() {

    val numbers = Regex("\\d+")

    /**
     * ### Part One
     *
     * Lights in your grid are numbered from 0 to 999 in each direction; the lights
     * at each corner are at 0,0, 0,999, 999,999, and 999,0. The instructions include
     * whether to turn on, turn off, or toggle various inclusive ranges given as coordinate
     * pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a
     * coordinate pair like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square.
     * The lights all start turned off.
     *
     * To defeat your neighbors this year, all you have to do is set up your lights by doing
     * the instructions Santa sent you in order.
     *
     * For example:
     *
     *      - turn on 0,0 through 999,999 would turn on (or leave on) every light.
     *      - toggle 0,0 through 999,0 would toggle the first line of 1000 lights,
     *        turning off the ones that were on, and turning on the ones that were off.
     *      - turn off 499,499 through 500,500 would turn off (or leave off) the middle four lights.
     *
     * After following the instructions, how many lights are lit?
     */
    override fun part1(): Any {
        val lights = Array(1000, { Array(1000, { 0 }) })
        file.readLines().forEach { line ->
            val (x0, y0, x1, y1) = numbers.findAll(line).map { it.value.toInt() }.toList()
            when {
                line.startsWith("turn on") -> operate(lights, x0, y0, x1, y1) { 1 }
                line.startsWith("turn off") -> operate(lights, x0, y0, x1, y1) { 0 }
                line.startsWith("toggle") -> operate(lights, x0, y0, x1, y1) { if (it == 0) 1 else 0 }
            }
        }
        return lights.map { row -> row.count { it == 1 }}.sum()
    }

    private fun operate(lights: Array<Array<Int>>, x0: Int, y0: Int, x1: Int, y1: Int, action: (Int) -> Int) {
        for(x in x0..x1) {
            for(y in y0..y1) {
                lights[x][y] = action(lights[x][y])
            }
        }
    }

    /**
     * ### Part Two
     *
     * You just finish implementing your winning light pattern when you realize you mistranslated Santa's
     * message from Ancient Nordic Elvish.
     *
     * The light grid you bought actually has individual brightness controls; each light can have a brightness
     * of zero or more. The lights all start at zero.
     *
     * The phrase turn on actually means that you should increase the brightness of those lights by 1.
     *
     * The phrase turn off actually means that you should decrease the brightness of those lights by 1,
     * to a minimum of zero.
     *
     * The phrase toggle actually means that you should increase the brightness of those lights by 2.
     *
     * What is the total brightness of all lights combined after following Santa's instructions?
     *
     * For example:
     *
     *      - turn on 0,0 through 0,0 would increase the total brightness by 1.
     *      - toggle 0,0 through 999,999 would increase the total brightness by 2000000.
     */
    override fun part2(): Any {
        val lights = Array(1000, { Array(1000, { 0 }) })
        file.readLines().forEach { line ->
            val (x0, y0, x1, y1) = numbers.findAll(line).map { it.value.toInt() }.toList()
            when {
                line.startsWith("turn on") -> operate(lights, x0, y0, x1, y1) { it + 1 }
                line.startsWith("turn off") -> operate(lights, x0, y0, x1, y1) { Math.max(0, it - 1) }
                line.startsWith("toggle") -> operate(lights, x0, y0, x1, y1) { it + 2 }
            }
        }
        return lights.map { row -> row.sum() }.sum()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Day6().run()
        }
    }
}