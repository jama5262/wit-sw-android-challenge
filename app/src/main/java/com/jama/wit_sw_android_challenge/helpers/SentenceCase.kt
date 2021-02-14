package com.jama.wit_sw_android_challenge.helpers

fun String.toSentenceCase(): String {
    return this.substring(0, 1).toUpperCase() +
            this.substring(1)
}