package com.github.marcospereira

data class Position(val x: Int, val y: Int)

object Instructions {
    val north = { p: Position -> p.copy(p.x, p.y + 1) }
    val south = { p: Position -> p.copy(p.x, p.y - 1) }
    val east = { p: Position -> p.copy(p.x + 1, p.y) }
    val west = { p: Position -> p.copy(p.x - 1, p.y) }
    val none = { p: Position -> p }
}

/**
 * ## Day 3: Perfectly Spherical Houses in a Vacuum
 *
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 *
 * He begins by delivering a present to the house at his starting location,
 * and then an elf at the North Pole calls him via radio and tells him where
 * to move next.
 */
class Day3() : Day() {

    val instructions = file.readText().map {
        when (it) {
            '^' -> Instructions.north
            'v' -> Instructions.south
            '>' -> Instructions.east
            '<' -> Instructions.west
            else -> Instructions.none
        }
    }

    /**
     * ### Part One
     *
     * Moves are always exactly one house to the north (`^`),
     * south (`v`), east (`>`), or west (`<`). After each move,
     * he delivers another present to the house at his new location.
     *
     * However, the elf back at the north pole has had a little too
     * much eggnog, and so his directions are a little off, and Santa
     * ends up visiting some houses more than once. How many houses
     * receive at least one present?
     *
     * For example:
     *
     *     - `>` delivers presents to 2 houses: one at the starting
     *       location, and one to the east.
     *     - `^>v<` delivers presents to 4 houses in a square, including
     *       twice to the house at his starting/ending location.
     *     - `^v^v^v^v^v` delivers a bunch of presents to some very
     *       lucky children at only 2 houses.
     */
    override fun part1(): Int {
        var currentPosition = Position(0, 0)
        var positions = hashSetOf(currentPosition)
        instructions.forEach { instruction ->
            currentPosition = instruction.invoke(currentPosition)
            positions.add(currentPosition)
        }
        return positions.size
    }

    /**
     * ### Part Two
     *
     * The next year, to speed up the process, Santa creates a robot version of
     * himself, Robo-Santa, to deliver presents with him.
     *
     * Santa and Robo-Santa start at the same location (delivering two presents to
     * the same starting house), then take turns moving based on instructions from
     * the elf, who is eggnoggedly reading from the same script as the previous year.
     *
     * This year, how many houses receive at least one present?
     *
     * For example:
     *
     *     - `^v` delivers presents to 3 houses, because Santa goes north,
     *       and then Robo-Santa goes south.
     *     - `^>v<` now delivers presents to 3 houses, and Santa and Robo-Santa
     *       end up back where they started.
     *     - `^v^v^v^v^v` now delivers presents to 11 houses, with Santa going
     *       one direction and Robo-Santa going the other.
     */
    override fun part2(): Int {
        var santaPosition = Position(0, 0)
        var robotPosition = Position(0, 0)
        var positions = hashSetOf(santaPosition, robotPosition)
        instructions.mapIndexedTo(positions) { index, instruction ->
            if (index % 2 == 0) {
                santaPosition = instruction.invoke(santaPosition)
                santaPosition
            } else {
                robotPosition = instruction.invoke(robotPosition)
                robotPosition
            }
        }
        return positions.size
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Day3().run()
        }
    }
}