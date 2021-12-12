package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BaekJoon_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int sum = -1;

        sum = find(N);

        System.out.println(sum);
    }

    public static int find(int n) {

        int temp = n;
        int count = temp / 5;
        int sum = -1;
        for (int i = 0; i <= count; i++) {
            temp = temp - 5 * i;
            temp = temp / 3;
            if ((3 * temp + 5 * i) == n) sum = temp + i;
            temp = n;
        }

        return sum;
    }
}
