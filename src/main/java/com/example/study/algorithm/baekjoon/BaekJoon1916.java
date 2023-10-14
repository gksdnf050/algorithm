package com.example.study.algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BaekJoon1916 {
    static List<Edge>[] list;
    static int[] dist;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        dist = new int[N];
        check = new boolean[N];

        for(int i = 0; i < N; i ++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i ++) {
           st = new StringTokenizer(br.readLine());
           list[Integer.parseInt(st.nextToken()) - 1].add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int des = Integer.parseInt(st.nextToken());

        dijkstra(start - 1);

        System.out.println(dist[des - 1]);
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue();
        q.add(new Edge(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Edge edge = q.poll();

            if(check[edge.dot] == true) continue;
            else check[edge.dot] = true;

            for(Edge e : list[edge.dot]) {
                if(dist[e.dot] > dist[edge.dot] + e.dis) {
                    dist[e.dot] = dist[edge.dot] + e.dis;
                    q.add(new Edge(e.dot, dist[e.dot]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    int dot;
    int dis;

    Edge(int dot, int dis) {
        this.dot = dot;
        this.dis = dis;
    }

    @Override
    public int compareTo(Edge o) {
        return this.dis - o.dis;
    }
}