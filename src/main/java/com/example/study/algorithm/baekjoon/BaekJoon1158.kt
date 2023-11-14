package com.example.study.algorithm.baekjoon

import java.util.LinkedList


fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (n, k) = bufferedReader.readLine().split(" ").map { it.toInt() }
    val circle = LinkedList<Int>().apply { addAll(1..n) }
    val result = mutableListOf<Int>()

    while (circle.isNotEmpty()) {
        repeat(k - 1) {
            circle.addLast(circle.removeFirst())
        }

        result.add(circle.removeFirst())
    }

    println("<${result.joinToString(", ")}>")
}