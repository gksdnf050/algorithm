package com.example.study.algorithm.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val count = bufferedReader.readLine().toInt()
    val result = StringBuilder()
    val stack = Stack<Int>()
    stack.push(1)
    result.append("+\n")
    var k = 2

    for(i in 1 .. count) {
        val value = bufferedReader.readLine().toInt()
        var go = true

        while(go) {
            if (count + 1 < k) {
                println("NO")
                return
            }

            if (stack.size  == 0) {
                stack.push(k++)
                result.append("+\n")
                continue
            }

            if (stack.peek() == value) {
                stack.pop()
                result.append("-\n")
                go = false
                continue
            }

            if (stack.peek() > value) {
                stack.pop()
                result.append("-\n")
                continue
            }

            if(stack.peek() < value) {
                stack.push(k++)
                result.append("+\n")
                continue
            }
        }
    }

    println(result)
}