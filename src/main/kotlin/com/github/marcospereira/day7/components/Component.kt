package com.github.marcospereira.day7.components

import java.util.*

/**
 * Created by francois on 2016-02-07.
 */
open class Component {
    val inputs = LinkedList<Component>()

    var value: Int = 0
        get() {
            if (!valid) {
                refresh()
            }
            return field
        }
        protected set

    var valid = false
        protected set

    fun invalidate() {
        if (!valid) {
            return
        }
        valid = false
        inputs.forEach {
            it.invalidate()
        }
    }

    open protected fun refresh() {
        if (valid) {
            return
        }
        valid = true
        inputs.forEach {
            it.refresh()
        }
    }
}