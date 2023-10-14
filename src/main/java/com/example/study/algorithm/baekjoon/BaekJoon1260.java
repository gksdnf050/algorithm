package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BaekJoon1260 {
    private static int N;
    private static int M;
    private static int V;
    private static int[][] graph;
    private static boolean[] bfsVisit;
    private static boolean[] dfsVisit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        bfsVisit = new boolean[N + 1];
        dfsVisit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfsWithStack(V);
        System.out.println("");
        bfs(V);

    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        bfsVisit[node] = true;

        while (q.isEmpty() == false) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for (int i = 0; i <= N; i ++) {
                if (bfsVisit[i] == false && graph[temp][i] == 1) {
                    q.add(i);
                    bfsVisit[i] = true;
                }
            }
        }
    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        dfsVisit[node] = true;

        for (int i = 0; i <= N; i++) {
            if (dfsVisit[i] == false && graph[node][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void dfsWithStack(int node) {
        Stack<Integer> s = new Stack<>();
        s.push(node);
        dfsVisit[node] = true;
        System.out.print(node + " ");

        boolean flag = true;

        while (s.isEmpty() == false) {
            int top = s.peek();

            flag = true;

            for (int i = 0; i <= N; i ++) {
                if (dfsVisit[i] == false && graph[top][i] == 1) {
                    s.push(i);
                    dfsVisit[i] = true;
                    System.out.print(i + " ");
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                s.pop();
            }
        }

    }
}