package com.example.study.algorithm.baekjoon

fun main() {
    val bufferedReader = System.`in`.bufferedReader()

    while (true) {
        val input = bufferedReader.readLine() ?: break

        var upperCount = 0
        var lowerCount = 0
        var blankCount = 0
        var numberCount = 0

        input.forEach {
            if ('0' <= it && it <= '9') {
                numberCount++
            }

            if ('a' <= it && it <= 'z') {
                lowerCount++
            }

            if ('A' <= it && it <= 'Z') {
                upperCount++
            }

            if (it.equals(' ')) {
                blankCount++
            }
        }

        println("${lowerCount} ${upperCount} ${numberCount} ${blankCount}")
    }
}