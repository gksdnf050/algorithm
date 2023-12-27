package com.example.study.algorithm.baekjoon

import java.util.Stack

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val input = bufferedReader.readLine()
    val temp = Stack<Char>()
    val result = StringBuilder()

    input.forEach {
        when(it) {
            '*', '/', '+', '-' -> {
                while (temp.isNotEmpty() && priority(it) <= priority(temp.peek())) {
                    result.append(temp.pop())
                }

                temp.push(it)
            }

            '(' -> {
                temp.push(it)
            }

            ')' -> {
                while (temp.isNotEmpty() && temp.peek() != '(') {
                    result.append(temp.pop())
                }

                temp.pop()
            }

            else -> {
                result.append(it)
            }
        }
    }

    while (temp.isNotEmpty()) {
        result.append(temp.pop())
    }

    println(result.toString())
}

fun priority(operator: Char): Int {
    return when(operator) {
        '(', ')' -> 0
        '+', '-' -> 1
        '*', '/' -> 2
        else -> -1
    }
}