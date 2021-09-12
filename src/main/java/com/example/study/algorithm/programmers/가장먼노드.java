package com.example.study.algorithm.programmers;

import java.util.*;

class 가장먼노드 {
    boolean check[];
    int distance[];
    List<Integer>[] list;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i[] : edge) {
            list[i[0] - 1].add(i[1] - 1);
            list[i[1] - 1].add(i[0] - 1);
        }

        check = new boolean[n];
        distance = new int[n];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        check[0] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int a : list[temp]) {
                if (check[a] == false) {
                    check[a] = true;
                    distance[a] = distance[temp] + 1;
                    q.add(a);
                }
            }
        }

        int max = 0;
        for (int i : distance) {
            if (i > max) {
                max = i;
            }
        }

        for (int i : distance) {
            if (max == i) {
                answer++;
            }
        }

        return answer;
    }
}
