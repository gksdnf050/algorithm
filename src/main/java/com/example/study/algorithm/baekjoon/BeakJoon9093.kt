package com.example.study.algorithm.baekjoon

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
    val count = bufferedReader.readLine().toInt()
    val result = StringBuilder()
    for (i in 1..count) {
        val sentence = bufferedReader.readLine()
        sentence.split(" ").forEach{
            result.append(it.reversed() + " ")
        }
        if (i != count) result.append("\n")
    }

    println(result)
}
