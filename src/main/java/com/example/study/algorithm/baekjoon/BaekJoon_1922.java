package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1922 {
    static int N;
    static int M;
    static int[] parent;
    static Queue<Com> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        q = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new Com(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int sum = 0;
        for (int i = 0; i < M; i++) {
            Com c = q.poll();
            int startP = find(c.start);
            int nextP = find(c.next);
            if (startP != nextP) {
                parent[startP] = nextP;
                sum += c.cost;
            }
        }

        System.out.println(sum);

    }

    public static int find(int node) {
        if (node == parent[node]) return node;

        return parent[node] = find(parent[node]);
    }

}

class Com implements Comparable<Com> {
    int start;
    int next;
    int cost;

    Com(int start, int next, int cost) {
        this.start = start;
        this.next = next;
        this.cost = cost;
    }

    @Override
    public int compareTo(Com o) {
        return this.cost - o.cost;
    }
}