package com.example.study.algorithm.baekjoon

import java.util.Stack

fun main() {
    val bufferedReader = System.`in`.bufferedReader()

    val n = bufferedReader.readLine().toInt()
    val result = MutableList(n) {
        -1
    }
    val inputArray = bufferedReader.readLine().split(" ").map { it.toInt() }.toMutableList()
    val output = Stack<Int>()

    inputArray.forEachIndexed { index, value ->
        if (output.isNotEmpty()) {
            if (inputArray[output.peek()] < value) {
                while (output.isNotEmpty() && inputArray[output.peek()] < value) {
                    result[output.peek()] = value
                    output.pop()
                }
            }

            output.push(index)
        } else {
            output.push(index)
        }
    }

    println(result.joinToString(" "))
}
