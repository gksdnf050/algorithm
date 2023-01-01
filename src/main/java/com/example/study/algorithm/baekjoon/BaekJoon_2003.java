package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int first = 0;
        int second = 0;
        int count = 0;
        int sum = 0;
        while (second <= N) {
            if(sum >= M) {
                sum -= arr[first];
                first++;
            } else {
                sum += arr[second];
                second++;
            }

            if(sum == M) count++;
        }

        System.out.println(count);
    }
}
