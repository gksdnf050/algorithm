package com.example.study.algorithm.baekjoon

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val (a, b, c) = bufferedReader.readLine().split(" ").map { it.toInt() }

    println((a+b)%c)
    println(((a%c) + (b%c))%c)
    println((a*b)%c)
    println(((a%c) * (b%c))%c)
}