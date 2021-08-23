package com.example.study.algorithm;

import java.util.*;

public class Dijkstra {
    public static List<Edge>[] list;
    public static boolean[] check;
    public static int[] dist;

    public static void main(String[] args) {
        list = new ArrayList[8];
        check = new boolean[8];
        dist = new int[8];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < 8; i++) list[i] = new ArrayList<>();

        list[0].add(new Edge(1,3));
        list[0].add(new Edge(4,4));
        list[0].add(new Edge(3,4));
        list[1].add(new Edge(2,2));
        list[2].add(new Edge(3,1));
        list[3].add(new Edge(4,2));
        list[4].add(new Edge(5,4));
        list[3].add(new Edge(6,6));
        list[6].add(new Edge(5,3));
        list[2].add(new Edge(7,3));
        list[5].add(new Edge(7,2));

        dijkstra(0);

        for(int i : dist) {
            System.out.println(i);
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> q = new PriorityQueue();
        q.add(new Edge(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Edge edge = q.poll();

            if(check[edge.getDestination()] == true) continue;
            else check[edge.getDestination()] = true;

            for(Edge e : list[edge.getDestination()]) {
                if(dist[e.getDestination()] > dist[edge.getDestination()] + e.getWeight()) {
                    dist[e.getDestination()] = dist[edge.getDestination()] + e.getWeight();
                    q.add(new Edge(e.getDestination(), dist[e.getDestination()]));
                }
            }
        }
    }
}

class Edge implements Comparable<Edge>{
    private int destination;
    private int weight;

    Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.getWeight() - o.getWeight();
    }
}
