package com.example.study.algorithm.baekjoon

import java.util.*

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val n = bufferedReader.readLine().toInt()
    val input = bufferedReader.readLine()
    val numArray = arrayOfNulls<Double>(n)
    repeat(n) {
        numArray[it] = bufferedReader.readLine().toDouble()
    }
    val temp = Stack<Double>()
    input.forEach {
        when(it) {
            '*' -> {
                val num1 = temp.pop()
                val num2 = temp.pop()
                temp.push(num2 * num1)
            }
            '/' -> {
                val num1 = temp.pop()
                val num2 = temp.pop()
                temp.push(num2 / num1)
            }
            '+' -> {
                val num1 = temp.pop()
                val num2 = temp.pop()
                temp.push(num2 + num1)
            }
            '-' -> {
                val num1 = temp.pop()
                val num2 = temp.pop()
                temp.push(num2 - num1)
            }
            else -> {
                temp.push(numArray[(it - 65).code])
            }
        }
    }

    println(String.format("%.2f", temp.pop()))
}