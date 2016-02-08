package com.github.marcospereira.day7

import com.github.marcospereira.Day
import com.github.marcospereira.day7.components.*
import java.util.*

/**
 * Created by francois on 2016-02-07.
 */
class Day7 : Day() {
    val seenWires = HashMap<String, Component>()
    val componentParser = "(?:([a-z0-9]+)\\s)?(?:(AND|OR|NOT|LSHIFT|RSHIFT)\\s)?([a-z0-9]+)\\s->\\s([a-z]+)".toPattern()

    fun getComponents() {
        file.readLines().forEach {
            val matcher = componentParser.matcher(it)
            if (matcher.matches()) {
                val in1Name = matcher.group(1)
                val gateName = matcher.group(2)
                val in2Name = matcher.group(3)
                val outName = matcher.group(4)

                val gate: Component = when (gateName) {
                    "AND" -> AndGate()
                    "OR" -> OrGate()
                    "NOT" -> NotGate()
                    "LSHIFT" -> LeftShiftGate()
                    "RSHIFT" -> RightShiftGate()
                    else -> TransmissionGate()
                }

                val in1 = seenWires.getOrDefault(in1Name, Wire(in1Name ?: ""))
                val in2 = seenWires.getOrDefault(in2Name, Wire(in2Name))
                val out = seenWires.getOrDefault(outName, Wire(outName))

                gate.inputs += in1
                gate.inputs += in2
                out.inputs += gate

                seenWires.putIfAbsent(in1Name, in1)
                seenWires.putIfAbsent(in2Name, in2)
                seenWires.putIfAbsent(outName, out)

            }
        }
    }

    override fun part1(): Any? {
        getComponents()
        val wire = seenWires["a"] ?: return 0
        val value = wire.value
        return value
    }

    override fun part2(): Any? {
        val wireA = seenWires["a"] ?: return 0
        val wireB = seenWires["b"] ?: return 0

        val overrideWire = Wire(wireA.value.toString())
        val overrideGate = TransmissionGate()

        overrideGate.inputs += overrideWire
        overrideGate.inputs += overrideWire

        wireB.inputs.clear()
        wireB.inputs += overrideGate

        wireA.invalidate()
        val value = wireA.value
        return value
    }
}