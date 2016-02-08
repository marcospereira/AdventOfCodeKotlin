package com.github.marcospereira.day7.components

import com.github.marcospereira.extensions.isNumeric

/**
 * Created by francois on 2016-02-07.
 */
class Wire(val name: String) : Component() {
    override fun refresh() {
        if (name == "") {
            return
        }
        super.refresh()
        if (name.isNumeric) {
            value = name.toInt()
        } else {
            value = inputs[0].value
        }
    }
}