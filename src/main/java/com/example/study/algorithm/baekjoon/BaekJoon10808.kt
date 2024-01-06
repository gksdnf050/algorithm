package com.example.study.algorithm.baekjoon

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val input = bufferedReader.readLine()
    val hashMap = hashMapOf<Char, Int>()
    for (i in 'a' .. 'z') {
        hashMap[i] = 0
    }

    input.forEach {
        hashMap[it] = hashMap[it]?.plus(1) ?: 1
    }

    print(hashMap.values.joinToString(" "))
}