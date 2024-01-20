package com.example.study.algorithm.baekjoon

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val input = bufferedReader.readLine()
    val map = hashMapOf<Char, Int>()
    val output = StringBuilder()
    input.forEachIndexed { index, c ->
        if (map.contains(c) == false) {
            map[c] = index
        }
    }

    for(i in 'a'..'z') {
        if (map.contains(i)) {
            output.append(map[i])
        } else {
            output.append(-1)
        }
        output.append(" ")
    }

    println(output)
}