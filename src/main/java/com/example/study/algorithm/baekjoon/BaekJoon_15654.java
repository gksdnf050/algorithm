package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_15654 {
    static int[] input;
    static int[] output;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        input = new int[N];
        output = new int[M];
        check = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        permu(0, M, N);
    }

    public static void permu(int depth, int m, int n) {
        if(depth == m) {
            for(int i : output) {
                System.out.print(i + " ");
            }
            System.out.println("");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(check[i] == false) {
                check[i] = true;
                output[depth] = input[i];
                permu(depth + 1 , m, n);
                check[i] = false;
            }
        }
    }

}
