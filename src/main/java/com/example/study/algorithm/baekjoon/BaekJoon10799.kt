package com.example.study.algorithm.baekjoon

import java.util.Stack

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val input = bufferedReader.readLine()
    val temp = Stack<Char>()
    var possibleRazer = false
    var number = 0

    input.forEach {
        if (it == '(') {
            temp.push(it)
            possibleRazer = true
        } else {
            if (possibleRazer) {
                temp.pop()
                number += temp.size
                possibleRazer = false
            } else {
                temp.pop()
                number += 1
            }
        }
    }

    println(number)
}