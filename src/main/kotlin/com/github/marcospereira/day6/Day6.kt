package com.github.marcospereira.day6

import com.github.marcospereira.Day
import java.util.*

/**
 * Created by francois on 2016-02-05.
 */

/**
 * --- Day 6: Probably a Fire Hazard ---
 * Because your neighbors keep defeating you in the holiday house decorating contest year after year, you've decided to
 * deploy one million lights in a 1000x1000 grid.
 */
class Day6() : Day() {
    val pattern = "(.*?)\\s(\\d{1,}),(\\d{1,})\\sthrough\\s(\\d{1,}),(\\d{1,})".toPattern()

    /**
     * Furthermore, because you've been especially nice this year, Santa has mailed you instructions on how to display the
     * ideal lighting configuration.
     * <p>
     * Lights in your grid are numbered from 0 to 999 in each direction; the lights at each corner are at 0,0, 0,999,
     * 999,999, and 999,0. The instructions include whether to turn on, turn off, or toggle various inclusive ranges given
     * as coordinate pairs. Each coordinate pair represents opposite corners of a rectangle, inclusive; a coordinate pair
     * like 0,0 through 2,2 therefore refers to 9 lights in a 3x3 square. The lights all start turned off.
     * <p>
     * To defeat your neighbors this year, all you have to do is set up your lights by doing the instructions Santa sent you
     * in order.
     * <p>
     * For example: turn on 0,0 through 999,999 would turn on (or leave on) every light. toggle 0,0 through 999,0 would
     * toggle the first line of 1000 lights, turning off the ones that were on, and turning on the ones that were off. turn
     * off 499,499 through 500,500 would turn off (or leave off) the middle four lights. After following the instructions,
     * how many lights are lit?
     */
    override fun part1(): Any {
        val operations = LinkedList<ArrayOperation2D<Boolean>>()
        val lights = Array(1000, { Array(1000, { false }) })

        file.readLines().forEach {
            val matcher = pattern.matcher(it)
            if (matcher.matches()) {
                val op = matcher.group(1)
                val startX = matcher.group(2).toInt()
                val startY = matcher.group(3).toInt()
                val endX = matcher.group(4).toInt()
                val endY = matcher.group(5).toInt()

                operations += when (op) {
                    "turn on" -> {
                        ArrayOperation2D(startX..endX, startY..endY, { x, y, array: Array<Array<Boolean>> ->
                            array[x][y] = true
                        })
                    }
                    "turn off" -> {
                        ArrayOperation2D(startX..endX, startY..endY, { x, y, array: Array<Array<Boolean>> ->
                            array[x][y] = false
                        })
                    }
                    "toggle" -> {
                        ArrayOperation2D(startX..endX, startY..endY, { x, y, array: Array<Array<Boolean>> ->
                            array[x][y] = !array[x][y]
                        })
                    }
                    else -> ArrayOperation2D(startX..endX, startY..endY, { x, y, array -> return@ArrayOperation2D })
                }
            }
        }

        operations.forEach { it.performAction(lights) }

        var litLights = 0
        lights.forEach {
            litLights += it.sumBy {
                return@sumBy if (it) 1 else 0
            }
        }
        return litLights
    }

    /**
     * You just finish implementing your winning light pattern when you realize you mistranslated Santa's message from
     * Ancient Nordic Elvish.
     *
     * The light grid you bought actually has individual brightness controls; each light can have a brightness of zero or
     * more. The lights all start at zero.
     *
     * The phrase turn on actually means that you should increase the brightness of those lights by 1.
     *
     * The phrase turn off actually means that you should decrease the brightness of those lights by 1, to a minimum of
     * zero.
     *
     * The phrase toggle actually means that you should increase the brightness of those lights by 2.
     *
     * What is the total brightness of all lights combined after following Santa's instructions?
     *
     * For example:
     *
     * turn on 0,0 through 0,0 would increase the total brightness by 1. toggle 0,0 through 999,999 would increase the total
     * brightness by 2000000.
     */
    override fun part2(): Any {
        val operations = LinkedList<ArrayOperation2D<Int>>()
        val lightsPart2 = Array(1000, { Array(1000, { 0 }) })

        file.readLines().forEach {
            val matcher = pattern.matcher(it)
            if (matcher.matches()) {
                val op = matcher.group(1)
                val startX = matcher.group(2).toInt()
                val startY = matcher.group(3).toInt()
                val endX = matcher.group(4).toInt()
                val endY = matcher.group(5).toInt()

                operations += when (op) {
                    "turn on" -> {
                        ArrayOperation2D(startX..endX, startY..endY, { x, y, array: Array<Array<Int>> ->
                            array[x][y] += 1
                        })
                    }
                    "turn off" -> {
                        ArrayOperation2D(startX..endX, startY..endY, { x, y, array: Array<Array<Int>> ->
                            array[x][y] -= 1
                            if (array[x][y] < 0) {
                                array[x][y] = 0
                            }
                        })
                    }
                    "toggle" -> {
                        ArrayOperation2D(startX..endX, startY..endY, { x, y, array: Array<Array<Int>> ->
                            array[x][y] += 2
                        })
                    }
                    else -> ArrayOperation2D(startX..endX, startY..endY, { x, y, array -> return@ArrayOperation2D })
                }
            }
        }

        operations.forEach { it.performAction(lightsPart2) }

        var litLights = 0
        lightsPart2.forEach {
            litLights += it.sumBy {
                return@sumBy it
            }
        }
        return litLights
    }

    class ArrayOperation2D<T>(val xRange: IntRange, val yRange: IntRange, val action: (Int, Int, Array<Array<T>>) -> Unit) {
        fun performAction(array: Array<Array<T>>) {
            for (i in xRange) {
                for (j in yRange) {
                    action(i, j, array)
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Day6().run()
        }
    }
}