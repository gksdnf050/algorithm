package com.example.study.algorithm.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 거리두기확인하기 {
    boolean[][] check;
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, 1, -1, 0};
    int[] answer;

    public int[] solution(String[][] places) {
        answer = new int[5];
        int i = 0;
        for (String[] str : places) {
            start(str, i++);
        }

        return answer;
    }

    public void start(String[] room, int k) {
        String[][] map = new String[5][5];

        for (int i = 0; i < 5; i++) {
            String str = room[i];
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j) + "";
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].equals("P")) {
                    check = new boolean[5][5];
                    boolean b = bfs(map, i, j);
                    if (b == false) {
                        answer[k] = 0;
                        return;
                    }
                }

            }
        }

        answer[k] = 1;
    }

    public boolean bfs(String[][] map, int x, int y) {
        Queue<Dot> q = new LinkedList();
        q.add(new Dot(x, y, 0));
        check[x][y] = true;

        while (!q.isEmpty()) {
            Dot d = q.poll();
            if (d.dis < 2) {
                for (int i = 0; i < 4; i++) {
                    int nx = d.x + dx[i];
                    int ny = d.y + dy[i];

                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && check[nx][ny] == false && map[nx][ny].equals("P")) {

                        return false;
                    }
                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && check[nx][ny] == false && map[nx][ny].equals("O")) {
                        check[nx][ny] = true;
                        q.add(new Dot(nx, ny, d.dis + 1));
                    }
                }
            }

        }

        return true;
    }
}

class Dot {
    int x;
    int y;
    int dis;

    Dot(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
