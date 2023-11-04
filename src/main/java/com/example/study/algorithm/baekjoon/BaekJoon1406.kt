package com.example.study.algorithm.baekjoon

import java.util.Stack

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val stringBuilder = StringBuilder()
    val input = bufferedReader.readLine()
    val leftStack = Stack<Char>()
    val rightStack = Stack<Char>()
    input.forEach {
        leftStack.add(it)
    }

    val count = bufferedReader.readLine().toInt()
    for(i in 0 until count) {
        val command = bufferedReader.readLine()
        val commandArray = command.split(" ")
        when(commandArray[0]) {
            "L" -> {
                if (leftStack.isNotEmpty()) rightStack.push(leftStack.pop())
            }
            "D" -> {
                if (rightStack.isNotEmpty()) leftStack.push(rightStack.pop())
            }
            "B" -> {
                if (leftStack.isNotEmpty()) leftStack.pop()
            }
            "P" -> {
                leftStack.push(commandArray[1].toCharArray()[0])
            }
        }
    }

    leftStack.forEach{
        stringBuilder.append(it)
    }
    rightStack.reverse()
    rightStack.forEach{
        stringBuilder.append(it)
    }

    println(stringBuilder)
}