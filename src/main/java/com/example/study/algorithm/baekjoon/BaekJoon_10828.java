package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_10828 {
    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        stack = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "top":
                    System.out.println(top());
                    break;
            }
        }
    }

    public static void push(int val) {
        stack[size] = val;
        size++;
    }

    public static int pop() {
        if (size == 0) return -1;

        int val = stack[size - 1];
        size--;

        return val;
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return size == 0 ? 1 : 0;
    }

    public static int top() {
        if (size == 0) return -1;

        int val = stack[size - 1];

        return val;
    }
}
