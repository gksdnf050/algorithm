package com.example.study.algorithm.baekjoon

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val input = bufferedReader.readLine()
    var stop = true
    val output = StringBuilder()
    var temp = StringBuilder()
    input.forEach {
        if (stop == false) {
            if (it == '>') {
                stop = true
            }
            output.append(it)
        } else {
            if (it == '<') {
                output.append(temp.reverse())
                temp = StringBuilder()
                output.append(it)
                stop = false
            } else if (it == ' ') {
                output.append(temp.reverse())
                output.append(" ")
                temp = StringBuilder()
            } else {
                temp.append(it)
            }
        }
    }

    output.append(temp.reverse())
    println(output)
}