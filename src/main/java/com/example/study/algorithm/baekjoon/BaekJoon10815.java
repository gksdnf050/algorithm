package com.example.study.algorithm.baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon10815 {
    public int M;
    public int N;
    public int[] base;
    public static void main(String[] args) throws IOException {
        BaekJoon10815 bj = new BaekJoon10815();
        bj.solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        base = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            base[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(base);

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            boolean b = find(Integer.parseInt(st.nextToken()));

            if (true == b) {
                bw.write("1 ");
                continue;
            }

            bw.write("0 ");
        }

        bw.close();
        br.close();
    }

    private boolean find(int number) {
        int left = 0;
        int right = base.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if (base[mid] == number) {
                return true;
            }

            if (base[mid] < number) {
                left = mid + 1;
            }

            if (base[mid] > number ) {
                right = mid - 1;
            }
        }

        return false;
    }
}
