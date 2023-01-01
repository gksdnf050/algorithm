package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_1260 {
    private static int N;
    private static int M;
    private static int V;
    private static int[][] graph;
    private static boolean[] bfs_visit;
    private static boolean[] dfs_visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        bfs_visit = new boolean[N + 1];
        dfs_visit = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // TODO memory address check
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        dfs(V);
        System.out.println("");
        bfs(V);

    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        bfs_visit[node] = true;

        while (q.isEmpty() == false) {
            int temp = q.poll();
            System.out.print(temp + " ");

            for (int i = 0; i <= N; i ++) {
                if (bfs_visit[i] == false && graph[temp][i] == 1) {
                    q.add(i);
                    bfs_visit[i] = true;
                }
            }
        }
    }

    private static void dfs(int node) {
        System.out.print(node + " ");
        dfs_visit[node] = true;

        for (int i = 0; i <= N; i++) {
            if (dfs_visit[i] == false && graph[i][node] == 1) {
                dfs(i);
            }
        }
    }
}