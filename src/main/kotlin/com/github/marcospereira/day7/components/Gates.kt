package com.github.marcospereira.day7.components

/**
 * Created by francois on 2016-02-07.
 */
class AndGate : Component() {
    override fun refresh() {
        super.refresh()
        value = (inputs[0].value and inputs[1].value) and 0xFFFF
    }
}

class OrGate : Component() {
    override fun refresh() {
        super.refresh()
        value = (inputs[0].value or inputs[1].value) and 0xFFFF
    }
}

class NotGate : Component() {
    override fun refresh() {
        super.refresh()
        value = (inputs[1].value.inv()) and 0xFFFF
    }
}

class LeftShiftGate() : Component() {
    override fun refresh() {
        super.refresh()
        value = (inputs[0].value shl inputs[1].value) and 0xFFFF
    }
}

class RightShiftGate() : Component() {
    override fun refresh() {
        super.refresh()
        value = (inputs[0].value shr inputs[1].value) and 0xFFFF
    }
}

class TransmissionGate() : Component() {
    override fun refresh() {
        valid = true
        value = inputs[1].value and 0xFFFF
    }
}
