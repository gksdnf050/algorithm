package com.example.study.algorithm.baekjoon

fun main() {
    val (a, b) =System.`in`.bufferedReader().readLine().split(" ").map { it.toInt() }
    val gcd = gcd(a, b)
    println(gcd)
    println(a * b / gcd)
}

fun gcd(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b
    var temp: Int
    while (num2 != 0) {
        temp = num2
        num2 = num1 % num2
        num1 = temp
    }

    return num1
}