package com.example.study.algorithm.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_4963 {
    static int w;
    static int h;
    static int arr[][];
    static boolean visit[][];
    static int dx[] = {-1,0,0,1,-1,1,-1,1};
    static int dy[] = {0,1,-1,0,1,1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) return;

            arr = new int[h][w];
            visit = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }

            }

//            for(int i = 0; i < h; i++) {
//                for(int j = 0; j < w; j++) {
//                    System.out.print(arr[i][j] + " ");
//                }
//                System.out.println("");
//            }

            int sum = 0;

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    if(arr[i][j] == 1 && visit[i][j] == false) {
                        calc(i,j);
                        sum++;
                    }
                }
            }

            System.out.println(sum);
        }

    }

    private static void calc(int x, int y) {
        visit[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));

        while(!q.isEmpty()) {
            Point temp = q.poll();

            for(int i = 0; i < 8; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if(nx >= 0 && nx < h && ny >= 0 && ny < w &&
                        arr[nx][ny] == 1 && visit[nx][ny] == false) {
                    visit[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }

    }

}
