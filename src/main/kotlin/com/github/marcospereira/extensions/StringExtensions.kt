package com.github.marcospereira.extensions

/**
 * Created by francois on 2016-02-07.
 */
val String.isNumeric: Boolean
    get() {
        try {
            Integer.parseInt(this)
            return true
        } catch (e: NumberFormatException) {
            return false
        }
    }
