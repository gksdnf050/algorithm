package com.example.study.algorithm.baekjoon

import java.util.*

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val n = bufferedReader.readLine().toInt()
    val input = bufferedReader.readLine().split(" ").map { it.toInt() }
    val result = MutableList(n) {
        -1
    }
    val count = hashMapOf<Int, Int>()
    val temp = Stack<Int>()

    input.forEach{
        count[it] = (count[it] ?: 0) + 1
    }

    input.forEachIndexed{index, value ->
        while (temp.isNotEmpty() && (count[value] ?: 0) > (count[input[temp.peek()]] ?: 0)) {
            result[temp.pop()] = value
        }

        temp.push(index)
    }

    println(result.joinToString(" "))
}