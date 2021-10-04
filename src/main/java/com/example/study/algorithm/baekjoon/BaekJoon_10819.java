package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_10819 {

    static int[] arr;
    static int[] result;
    static boolean[] check;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        check = new boolean[N];
        result = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        permu(0, N);

        System.out.println(answer);
    }

    public static void permu(int depth, int n) {
        if (depth == n) {
            calc();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check[i] == false) {
                check[i] = true;
                result[depth] = arr[i];
                permu(depth + 1, n);
                check[i] = false;
            }
        }
    }

    public static void calc() {
        int sum = 0;
        for (int i = 0; i < result.length - 1; i++) {
            sum += Math.abs(result[i] - result[i + 1]);
        }

        if (answer < sum) answer = sum;
    }
}
