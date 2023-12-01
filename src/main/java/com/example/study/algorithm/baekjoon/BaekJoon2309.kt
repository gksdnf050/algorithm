package com.example.study.algorithm.baekjoon

var a = false

fun main() {
    val bufferedReader = System.`in`.bufferedReader()
    val input = Array(9) { 0 }
    val output = Array(7) { 0 }
    val visit = Array(9) { false }
    repeat(9) {
        input[it] = bufferedReader.readLine().toInt()
    }

    permutation(input, output, visit, 0, 9, 7)

    output.sort()
    output.forEach {
        println(it)
    }
}

fun permutation(input: Array<Int>, output: Array<Int>, visit: Array<Boolean>, depth: Int, n: Int, r: Int) {
    if (depth == r) {
        a = check(output)
        return
    }

    for (i in 0 until n) {
        if (!visit[i]) {
            visit[i] = true
            output[depth] = input[i]
            permutation(input, output, visit, depth + 1, n , r)
            if (a) return
            visit[i] = false
        }

    }
}

fun check(result: Array<Int>): Boolean {
    return result.sum() == 100
}
